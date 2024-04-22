package com.ahbap.android.app.comunitationandroidapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ahbap.android.app.comunitationandroidapplication.databinding.ActivityMainBinding
import com.ahbap.android.app.comunitationandroidapplication.view.MainActivityListener

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding : ActivityMainBinding

    private fun initialize()
    {
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        mBinding.view = MainActivityListener(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        initialize()
    }

    fun RegisterButton()
    {
        Intent(this,RegisterActivity::class.java).apply {
            startActivity(this)
        }
    }
    fun LoginButton()
    {
        Intent(this,LoginActivity::class.java)
            .apply { startActivity(this) }
    }
}