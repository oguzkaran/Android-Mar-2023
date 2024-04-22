package com.ahbap.android.app.comunitationandroidapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.ahbap.android.app.comunitationandroidapplication.databinding.ActivityLoginBinding
import com.ahbap.android.app.comunitationandroidapplication.login.NickNameAndPassword
import com.ahbap.android.app.comunitationandroidapplication.login.view.ActivityLoginListener

class Login : AppCompatActivity() {
    private lateinit var mBinding : ActivityLoginBinding

    private fun initialize()
    {
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        mBinding.view = ActivityLoginListener(this)
        mBinding.user = NickNameAndPassword()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       initialize()
    }

    fun GetButton()
    {

    }
}