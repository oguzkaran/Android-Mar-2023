package org.csystem.android.app.payment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.csystem.android.app.payment.data.service.dto.LoginInfoDTO
import org.csystem.android.app.payment.databinding.ActivityPaymentBinding
import org.csystem.android.app.payment.global.getLoginInfo
import org.csystem.android.app.payment.global.key.LOGIN_INFO
import org.csystem.android.app.payment.viewmodel.PaymentActivityListenerViewModel

class PaymentActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityPaymentBinding
    private lateinit var mLoginInfo: LoginInfoDTO

    private fun initLoginInfo()
    {
        mLoginInfo =  getLoginInfo(intent)
    }

    private fun initBinding()
    {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_payment)
        mBinding.viewModel = PaymentActivityListenerViewModel(this)
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

    fun makePaymentButtonClicked()
    {
        Intent(this, MakePaymentActivity::class.java).apply{putExtra(LOGIN_INFO, mLoginInfo); startActivity(this)}
    }

    fun paymentsButtonClicked()
    {
        Intent(this, PaymentsActivity::class.java).apply{putExtra(LOGIN_INFO, mLoginInfo); startActivity(this)}
    }

    fun closeButtonClicked()
    {
        finish()
    }
}