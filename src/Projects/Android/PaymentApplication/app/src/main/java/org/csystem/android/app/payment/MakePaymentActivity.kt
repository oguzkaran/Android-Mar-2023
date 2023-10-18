package org.csystem.android.app.payment

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.karandev.util.data.service.DataServiceException
import dagger.hilt.android.AndroidEntryPoint
import org.csystem.android.app.payment.data.service.PaymentApplicationDataService
import org.csystem.android.app.payment.data.service.dto.LoginInfoDTO
import org.csystem.android.app.payment.data.service.dto.PaymentSaveDTO
import org.csystem.android.app.payment.databinding.ActivityMakePaymentBinding
import org.csystem.android.app.payment.global.getLoginInfo
import org.csystem.android.app.payment.viewmodel.MakePaymentActivityListenerViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MakePaymentActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMakePaymentBinding

    private lateinit var mLoginInfo: LoginInfoDTO

    @Inject
    lateinit var paymentApplicationDataService: PaymentApplicationDataService

    private fun initLoginInfo()
    {
        mLoginInfo =  getLoginInfo(intent)
    }

    private fun initBinding()
    {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_make_payment)
        mBinding.viewModel = MakePaymentActivityListenerViewModel(this)
        initLoginInfo()
        mBinding.paymentInfo = PaymentSaveDTO(mLoginInfo.username)
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

    fun payButtonClicked()
    {
        try {
            //check data for validation
            paymentApplicationDataService.savePayment(mBinding.paymentInfo!!)
        }
        catch (ex: DataServiceException) {
            Log.d("data_service", ex.message!!)
        }
        catch (ex: Throwable) {
            Log.d("any-problem", ex.message!!)
        }
    }

    fun clearButtonClicked()
    {

    }

    fun closeButtonClicked()
    {
        finish()
    }
}