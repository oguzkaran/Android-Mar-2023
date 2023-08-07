package org.csystem.android.app.multipleactivity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.csystem.android.app.multipleactivity.databinding.ActivityLoginBinding
import org.csystem.android.app.multipleactivity.keys.LOGIN_INFO
import org.csystem.android.app.multipleactivity.viewmodel.LoginActivityListenersViewModel
import org.csystem.android.app.multipleactivity.viewmodel.LoginInfo
import java.time.LocalDateTime

class LoginActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityLoginBinding

    private fun initViewModels()
    {
        mBinding.viewModel = LoginActivityListenersViewModel(this)
        mBinding.loginInfo = LoginInfo()
    }

    private fun initialize()
    {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        initViewModels()
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        initialize()
    }

    fun loginButtonClicked()
    {
        //...
        Intent(this, PaymentActivity::class.java).apply {
            mBinding.loginInfo!!.loginDateTime = LocalDateTime.now()
            startActivity(putExtra(LOGIN_INFO, mBinding.loginInfo))
        }
    }
}