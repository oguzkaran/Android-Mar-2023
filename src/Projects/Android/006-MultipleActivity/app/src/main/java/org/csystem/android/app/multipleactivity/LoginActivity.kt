package org.csystem.android.app.multipleactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.csystem.android.app.multipleactivity.databinding.ActivityLoginBinding
import org.csystem.android.app.multipleactivity.keys.LOGIN_INFO
import org.csystem.android.app.multipleactivity.keys.PRODUCT_NAME
import org.csystem.android.app.multipleactivity.keys.TOTAL_PRICE
import org.csystem.android.app.multipleactivity.viewmodel.LoginActivityListenersViewModel
import org.csystem.android.app.multipleactivity.viewmodel.LoginInfo
import java.time.LocalDateTime

class LoginActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityLoginBinding
    private lateinit var mLauncher: ActivityResultLauncher<Intent>

    private fun paymentActivityCallback(result: ActivityResult)
    {
        if (result.resultCode != RESULT_OK)
            return

        val data = result.data
        val productName = data?.getStringExtra(PRODUCT_NAME)
        val totalPrice = data?.getDoubleExtra(TOTAL_PRICE, 0.0)
        "%.2f paid for '%s'".format(totalPrice, productName)
            .apply { Toast.makeText(this@LoginActivity, this, Toast.LENGTH_LONG).show() }
    }

    private fun initPaymentActivityResultLauncher()
    {
        mLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {paymentActivityCallback(it)}
    }

    private fun initViewModels()
    {
        mBinding.viewModel = LoginActivityListenersViewModel(this)
        mBinding.loginInfo = LoginInfo()
    }

    private fun initialize()
    {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        initViewModels()
        initPaymentActivityResultLauncher()
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
            putExtra(LOGIN_INFO, mBinding.loginInfo)
            mLauncher.launch(this)
        }
    }
}