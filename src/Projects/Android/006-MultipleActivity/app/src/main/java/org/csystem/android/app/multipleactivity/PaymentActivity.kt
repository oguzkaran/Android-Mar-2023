package org.csystem.android.app.multipleactivity

import android.app.AlertDialog
import android.content.Intent
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.csystem.android.activity.viewmodel.LoginInfo
import org.csystem.android.app.multipleactivity.databinding.ActivityPaymentBinding
import org.csystem.android.app.multipleactivity.keys.LOGIN_INFO
import org.csystem.android.app.multipleactivity.keys.PRODUCT_NAME
import org.csystem.android.app.multipleactivity.keys.TOTAL_PRICE
import org.csystem.android.app.multipleactivity.viewmodel.PaymentActivityListenersViewModel
import org.csystem.android.app.multipleactivity.viewmodel.PaymentInfo
import org.csystem.app.multipleactivity.library.databinding.converter.PaymentQuantityStringConverter
import org.csystem.app.multipleactivity.library.databinding.converter.PaymentUnitPriceStringConverter

class PaymentActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityPaymentBinding

    private fun closeAlertDialogPositiveButtonCallback()
    {
        if (mBinding.result!!.isNotEmpty())
            Intent().apply {
                //Buradaki bilgiler örnek amaçlı geçilmiştir. Pratikte PaymentInfo Serializable yapılıp doğrudan bundle'a eklenebilir
                putExtra(PRODUCT_NAME, mBinding.paymentInfo!!.name)
                putExtra(TOTAL_PRICE, mBinding.paymentInfo!!.total)
                setResult(RESULT_OK, this)
            }
        finish()
    }

    private fun initViewModels()
    {
        mBinding.viewModel = PaymentActivityListenersViewModel(this)
        mBinding.loginInfo =  when {
            VERSION.SDK_INT < VERSION_CODES.TIRAMISU -> intent.getSerializableExtra(LOGIN_INFO) as LoginInfo
            else -> intent.getSerializableExtra(LOGIN_INFO, LoginInfo::class.java)
        }
        mBinding.paymentInfo = PaymentInfo()
        mBinding.result = ""
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
        mBinding.result = ""
        if (checkFail().isNotEmpty())
            return

        mBinding.result = mBinding.paymentInfo!!.toString()
    }

    fun clearButtonClicked()
    {
        mBinding.paymentInfo = PaymentInfo()
        mBinding.result = ""
    }

    fun closeButtonClicked()
    {
        AlertDialog.Builder(this)
            .setTitle(R.string.alert_dialog_close_title)
            .setMessage(R.string.alert_dialog_close_message)
            .setPositiveButton(R.string.alert_dialog_close_positive_button_text) {_, _ -> closeAlertDialogPositiveButtonCallback()}
            .setNegativeButton(R.string.alert_dialog_close_negative_button_text) {_, _ -> }
            .create()
            .show()
    }

    fun exitButtonClicked()
    {
        TODO("Not implemented yet!...")
    }
}