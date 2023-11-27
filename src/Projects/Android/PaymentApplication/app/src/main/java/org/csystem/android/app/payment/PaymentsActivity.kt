package org.csystem.android.app.payment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import org.csystem.android.app.payment.data.service.dto.LoginInfoDTO
import org.csystem.android.app.payment.databinding.ActivityPaymentsBinding
import org.csystem.android.app.payment.global.getLoginInfo
import java.util.concurrent.ScheduledExecutorService
import javax.inject.Inject

@AndroidEntryPoint
class PaymentsActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityPaymentsBinding

    @Inject
    lateinit var threadPool: ScheduledExecutorService

    private lateinit var mLoginInfo: LoginInfoDTO

    private fun listPaymentsButtonClickedCallback()
    {
        //TODO
    }

    private fun initLoginInfo()
    {
        mLoginInfo =  getLoginInfo(intent)
    }

    private fun initBinding()
    {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_payments)
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

    fun listPaymentsButtonClicked() = threadPool.execute{listPaymentsButtonClickedCallback()}
}