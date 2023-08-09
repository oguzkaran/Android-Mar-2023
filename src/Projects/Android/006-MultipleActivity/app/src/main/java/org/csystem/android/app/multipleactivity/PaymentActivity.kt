package org.csystem.android.app.multipleactivity

import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.csystem.android.app.multipleactivity.binding.PaymentQuantityStringConverter
import org.csystem.android.app.multipleactivity.binding.PaymentUnitPriceStringConverter
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
        mBinding.paymentInfo = PaymentInfo()
        mBinding.result = "";
        PaymentQuantityStringConverter.failStr = "Invalid quantity"
        PaymentUnitPriceStringConverter.failStr = "Invalid unit price"
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

    private fun checkFailListAppCallback(list: MutableList<String>) : List<String>
    {
        if (PaymentQuantityStringConverter.fail)
            list.add(PaymentQuantityStringConverter.failStr)

        if (PaymentUnitPriceStringConverter.fail)
            list.add(PaymentUnitPriceStringConverter.failStr)

        if (list.isNotEmpty())
            Toast.makeText(this, list.joinToString("\n"), Toast.LENGTH_LONG).show()

        return list
    }

    private fun checkFail() = ArrayList<String>().apply {checkFailListAppCallback(this)}

    fun payButtonClicked()
    {
        mBinding.result = "";
        if (checkFail().isNotEmpty())
            return

        mBinding.result = mBinding.paymentInfo!!.toString()
    }

    fun clearButtonClicked()
    {

    }

    fun closeButtonClicked()
    {

    }
}