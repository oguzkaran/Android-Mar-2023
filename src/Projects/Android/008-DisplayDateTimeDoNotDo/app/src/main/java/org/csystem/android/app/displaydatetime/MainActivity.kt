package org.csystem.android.app.displaydatetime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        initialize()
    }

    override fun onResume()
    {
        mFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm:ss")
        super.onResume()
        while (true) {
            mBinding.dateTime = mFormatter.format(LocalDateTime.now())
            Thread.sleep(1000)
        }
    }
}