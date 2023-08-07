package org.csystem.android.app.multipleactivity

import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.csystem.android.app.multipleactivity.databinding.ActivityPaymentBinding
import org.csystem.android.app.multipleactivity.keys.LOGIN_INFO
import org.csystem.android.app.multipleactivity.viewmodel.LoginInfo
import org.csystem.android.app.multipleactivity.viewmodel.PaymentActivityViewModel
import org.csystem.android.app.multipleactivity.viewmodel.PaymentInfo

class PaymentActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityPaymentBinding

    private fun initViewModels()
    {
        mBinding.viewModel = PaymentActivityViewModel(this)
        mBinding.loginInfo =  when {
            VERSION.SDK_INT < VERSION_CODES.TIRAMISU -> intent.getSerializableExtra(LOGIN_INFO) as LoginInfo
            else -> intent.getSerializableExtra(LOGIN_INFO, LoginInfo::class.java)
        }
        mBinding.result = "";
    }

    private fun initBinding()
    {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_payment)
        initViewModels()
    }

    private fun initialize()
    {
        initBinding()
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        initialize()
        Toast.makeText(this, mBinding.loginInfo!!.password, Toast.LENGTH_LONG).show()
    }

    fun payButtonClicked()
    {
        try {
            //Şimdilik bu şekilde yapılmıştırü
            mBinding.result = "";
            val pi = PaymentInfo(mBinding.viewModel!!.name,
                mBinding.viewModel!!.unitPriceStr.toDouble(), mBinding.viewModel!!.quantityStr.toInt())

            mBinding.result = pi.toString()
        }
        catch (ignore: Throwable) {
            Toast.makeText(this, "Problem occurs!...", Toast.LENGTH_LONG).show()
        }
    }

    fun clearButtonClicked()
    {

    }

    fun closeButtonClicked()
    {

    }
}