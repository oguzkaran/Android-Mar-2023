package org.csystem.android.app.displaydatetime

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.csystem.android.app.displaydatetime.databinding.ActivityMainBinding
import org.csystem.android.util.datetime.di.module.formatter.annotation.LocalDateTimeFormatterInterceptor
import org.csystem.android.util.datetime.di.module.formatter.annotation.LocalTimeFormatterInterceptor
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Timer
import java.util.TimerTask
import javax.inject.Inject
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mTimerDateTime: Timer
    private lateinit var mClockThread: Thread

    private fun createDateTimeTimerTask() = object: TimerTask() {
        override fun run()
        {
            mBinding.dateTime = dateTimeFormatter.format(LocalDateTime.now())
        }
    }


    private fun scheduleDateTimeTimer()
    {
        mTimerDateTime = Timer()
        dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm:ss")
        mTimerDateTime.scheduleAtFixedRate(createDateTimeTimerTask(), 0, 1000)
    }

    private fun clockThreadCallback()
    {
        timeFormatter = DateTimeFormatter.ofPattern("kk:mm:ss")
        //Şüphesiz timer kullanımı daha uygundur. Durumu göstermek için bu şekilde yazılmıştır
        while (true) {
            mBinding.time = timeFormatter.format(LocalTime.now())
            Thread.sleep(1000)
        }
    }

    private fun startClock()
    {
        mClockThread = thread { clockThreadCallback() }
    }

    @Inject
    @LocalDateTimeFormatterInterceptor
    lateinit var dateTimeFormatter : DateTimeFormatter

    @Inject
    @LocalTimeFormatterInterceptor
    lateinit var timeFormatter : DateTimeFormatter

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

    override fun onStart()
    {
        try {
            scheduleDateTimeTimer()
            startClock()
            super.onStart()
        }
        catch (ex: Throwable) {
            Log.d("on-start", ex.message!!)
            Toast.makeText(this, "Problem occured on start!...", Toast.LENGTH_LONG).show()
        }
    }

    override fun onStop()
    {
        try {
            mTimerDateTime.cancel()
            mClockThread.interrupt()
            super.onStop()
        }
        catch (ex: Throwable) {
            Log.d("on-stop", ex.message!!)
            Toast.makeText(this, "Problem occured on stop!...", Toast.LENGTH_LONG).show()
        }
    }

    //...
}