package org.csystem.android.app.displaydatetime

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.csystem.android.app.displaydatetime.databinding.ActivityMainBinding
import org.csystem.android.util.datetime.di.module.formatter.annotation.LocalDateTimeFormatterInterceptor
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Timer
import java.util.TimerTask
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mTimer: Timer

    private fun createTimerTask() = object: TimerTask() {
        override fun run()
        {
            mBinding.dateTime = mFormatter.format(LocalDateTime.now())
        }
    }

    @Inject
    @LocalDateTimeFormatterInterceptor
    lateinit var mFormatter : DateTimeFormatter

    private fun initBinding()
    {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private fun initialize()
    {
        initBinding()
        mTimer = Timer()
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        initialize()
    }

    override fun onResume()
    {
        mFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm:ss")
        mTimer.scheduleAtFixedRate(createTimerTask(), 0, 1000)
        super.onResume()
    }

    //...
}