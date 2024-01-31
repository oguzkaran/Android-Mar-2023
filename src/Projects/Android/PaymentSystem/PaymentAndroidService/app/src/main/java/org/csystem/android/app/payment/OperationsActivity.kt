package org.csystem.android.app.payment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.csystem.android.app.payment.data.service.dto.LoginInfoSaveDTO
import org.csystem.android.app.payment.databinding.ActivityOperationsBinding
import org.csystem.android.app.payment.global.getLoginInfo
import org.csystem.android.app.payment.global.key.LOGIN_INFO
import org.csystem.android.app.payment.viewmodel.OperationsActivityListenerViewModel

class OperationsActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityOperationsBinding

    private lateinit var mLoginInfo: LoginInfoSaveDTO

    private fun initLoginInfo()
    {
        mLoginInfo =  getLoginInfo(intent)
    }

    private fun initBinding()
    {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_operations)
        mBinding.viewModel = OperationsActivityListenerViewModel(this)
    }

    private fun initialize()
    {
        initBinding()
        initLoginInfo()
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        initialize()
    }

    fun paymentButtonClicked()
    {
        Intent(this, PaymentActivity::class.java).apply { putExtra(LOGIN_INFO, mLoginInfo); startActivity(this) }
    }

    fun loginInformationButtonClicked()
    {
        Intent(this, LoginInformationActivity::class.java).apply { putExtra(LOGIN_INFO, mLoginInfo); startActivity(this) }
    }

    fun closeButtonClicked()
    {
        finish()
    }
}