package org.csystem.android.app.displaydatetime

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.csystem.android.app.displaydatetime.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivitySplashBinding

    private fun initCountDownTimer()
    {
        object: CountDownTimer(10000, 1000) {
            override fun onTick(remainingMillis: Long)
            {
                mBinding.counter = (remainingMillis / 1000).toString()
            }

            override fun onFinish()
            {
                finish()
                Intent(this@SplashActivity, MainActivity::class.java).apply { startActivity(this) }
            }
        }.start()
    }

    private fun initBinding()
    {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
    }

    private fun initialize()
    {
        initBinding()
        initCountDownTimer()
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        initialize()
    }
}