package org.csystem.android.app.displaydatetime

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
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

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mTimerDateTime: Timer
    private lateinit var mChronoTimer: Timer
    private lateinit var mClockThread: Thread

    @Inject
    @LocalDateTimeFormatterInterceptor
    lateinit var dateTimeFormatter : DateTimeFormatter

    @Inject
    @LocalTimeFormatterInterceptor
    lateinit var timeFormatter : DateTimeFormatter

    private fun createDateTimeTimerTask() = object: TimerTask() {
        override fun run()
        {
            mBinding.dateTime = dateTimeFormatter.format(LocalDateTime.now())
        }
    }

    private fun createChronoTimerTask() : TimerTask
    {
        var seconds = 0L

        return object: TimerTask() {
            override fun run()
            {
                displayChronoDuration(seconds++)
            }
        }
    }

    private fun displayChronoDuration(seconds: Long)
    {
        val hour = seconds / 60 / 60
        val minute = seconds / 60 % 60
        val second = seconds % 60

        mBinding.chronometer = "%02d:%02d:%02d".format(hour, minute, second)
    }

    private fun scheduleDateTimeTimer()
    {
        mTimerDateTime = Timer()
        mTimerDateTime.scheduleAtFixedRate(createDateTimeTimerTask(), 0, 1000)
    }

    private fun scheduleChronoTimer()
    {
        mChronoTimer = Timer()
        mChronoTimer.scheduleAtFixedRate(createChronoTimerTask(), 0, 1000)
    }

    private fun startAutoDisplayChronometer()
    {
        mBinding.mainActivityChronometerAutoDisplay.start()
    }

    private fun clockThreadCallback()
    {
        //Şüphesiz timer kullanımı daha uygundur. Durumu göstermek için bu şekilde yazılmıştır
        try {
            while (true) {
                mBinding.time = timeFormatter.format(LocalTime.now())
                Thread.sleep(1000)
            }
        }
        catch (_ : InterruptedException) {
            runOnUiThread{Toast.makeText(this, "Artık sonlanmak lazım", Toast.LENGTH_LONG).show()}
        }
    }

    private fun startClock()
    {
        mClockThread = thread { clockThreadCallback() }
    }

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
            scheduleChronoTimer()
            startAutoDisplayChronometer()
            startClock()
            super.onStart()
        }
        catch (ex: Throwable) {
            Log.d("on-start", ex.message!!)
            Toast.makeText(this, "Problem occurred on start!...", Toast.LENGTH_LONG).show()
        }
    }

    override fun onStop()
    {
        try {
            mTimerDateTime.cancel()
            mChronoTimer.cancel()
            mClockThread.interrupt()
            mBinding.mainActivityChronometerAutoDisplay.stop()
            super.onStop()
        }
        catch (ex: Throwable) {
            Log.d("on-stop", ex.message!!)
            Toast.makeText(this, "Problem occured on stop!...", Toast.LENGTH_LONG).show()
        }
    }

    //...
}