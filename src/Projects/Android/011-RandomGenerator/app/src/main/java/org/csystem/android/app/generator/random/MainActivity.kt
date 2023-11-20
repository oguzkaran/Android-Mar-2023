package org.csystem.android.app.generator.random

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import org.csystem.android.app.generator.random.databinding.ActivityMainBinding
import org.csystem.android.app.generator.random.string.generateRandomTextEN
import org.csystem.android.app.generator.random.viewmodel.data.GenerateInfo
import org.csystem.android.app.generator.random.viewmodel.listener.MainActivityListenerViewModel
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException
import javax.inject.Inject
import kotlin.random.Random

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mScheduledFuture: ScheduledFuture<*>

    @Inject
    lateinit var executorService: ScheduledExecutorService

    private fun waitScheduler()
    {
        try {
            mScheduledFuture.get(mBinding.generateInfo!!.period * mBinding.generateInfo!!.count, TimeUnit.SECONDS)
        }
        catch (_: TimeoutException) {
            mScheduledFuture.cancel(false)
        }
    }

    private fun schedulerTrackCallback()
    {
        //Aslında burada scheduler yerine thread kullanılması daha uygundur. Örnek amaçlı bu şekilde yazılmıştır
        try {
            mBinding.enabled = false
            mScheduledFuture = executorService.scheduleAtFixedRate(
                { schedulerCallback() },
                0L,
                mBinding.generateInfo!!.period,
                TimeUnit.SECONDS
            )
            waitScheduler()
        }
        catch (ex: Throwable) {
            runOnUiThread{Toast.makeText(this, "Poblem occurred in scheduler track thread:${ex.message}", Toast.LENGTH_LONG).show()}
        }
        finally {
            mBinding.enabled = true
        }
    }

    private fun schedulerCallback()
    {
        try {
            runOnUiThread {
                mBinding.adapter!!.add(
                    generateRandomTextEN(
                        Random.nextInt(
                            mBinding.generateInfo!!.minimum,
                            mBinding.generateInfo!!.maximum + 1
                        )
                    )
                )
            }
        }
        catch (ex: Throwable) {
            runOnUiThread{Toast.makeText(this, "Poblem occurred in scheduler:${ex.message}", Toast.LENGTH_LONG).show()}
        }
    }

    private fun initViewModels()
    {
        mBinding.viewModel = MainActivityListenerViewModel(this)
        mBinding.generateInfo = GenerateInfo()
        mBinding.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, ArrayList<String>())
        mBinding.enabled = true
    }

    private fun initBinding()
    {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initViewModels()
    }

    private fun initialize()
    {
        initBinding()
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        initialize()
    }

    fun generateButtonClicked() = executorService.execute{schedulerTrackCallback()}

    fun saveButtonClicked()
    {
        //TODO:
    }

    fun clearButtonClicked()
    {
        mBinding.adapter!!.clear()
    }
}