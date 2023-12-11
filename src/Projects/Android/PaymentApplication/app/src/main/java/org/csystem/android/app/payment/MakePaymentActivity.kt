package org.csystem.android.app.payment

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.karandev.util.data.service.DataServiceException
import dagger.hilt.android.AndroidEntryPoint
import org.csystem.android.app.payment.data.service.PaymentApplicationDataService
import org.csystem.android.app.payment.data.service.dto.LoginInfoSaveDTO
import org.csystem.android.app.payment.data.service.dto.PaymentSaveDTO
import org.csystem.android.app.payment.databinding.ActivityMakePaymentBinding
import org.csystem.android.app.payment.global.getLoginInfo
import org.csystem.android.app.payment.viewmodel.MakePaymentActivityListenerViewModel
import java.util.concurrent.ScheduledExecutorService
import javax.inject.Inject

@AndroidEntryPoint
class MakePaymentActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMakePaymentBinding

    private lateinit var mLoginInfo: LoginInfoSaveDTO

    @Inject
    lateinit var paymentApplicationDataService: PaymentApplicationDataService

    @Inject
    lateinit var threadPool: ScheduledExecutorService

    private fun payButtonClickedCallback()
    {
        try {
            //check data for validation
            paymentApplicationDataService.savePayment(mBinding.paymentInfo!!)
            runOnUiThread{Toast.makeText(this, "Paid successfully!...", Toast.LENGTH_LONG).show()}
        }
        catch (ex: DataServiceException) {
            runOnUiThread{Toast.makeText(this, "Data Problem occurred!...", Toast.LENGTH_LONG).show()}
            Log.d("data_service", ex.message!!)
        }
        catch (ex: Throwable) {
            runOnUiThread{Toast.makeText(this, "Problem occurred!...", Toast.LENGTH_LONG).show()}
            Log.d("any-problem", ex.message!!)
        }
    }

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

    fun payButtonClicked() = threadPool.execute{payButtonClickedCallback()}

    fun clearButtonClicked()
    {
        for (i in 0..<mBinding.makePaymantActivityLinearLayoutMain.childCount) {
            val view = mBinding.makePaymantActivityLinearLayoutMain.getChildAt(i)

            if (view is EditText)
                view.setText("")
        }
    }

    fun closeButtonClicked()
    {
        finish()
    }
}