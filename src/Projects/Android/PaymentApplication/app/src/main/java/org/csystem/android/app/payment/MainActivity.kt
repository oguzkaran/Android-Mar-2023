package org.csystem.android.app.payment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import org.csystem.android.app.payment.databinding.ActivityMainBinding
import org.csystem.android.app.payment.viewmodel.MainActivityListenerViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding

    private fun initialize()
    {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.viewModel = MainActivityListenerViewModel(this)
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        initialize()
    }

    fun registerButtonClicked()
    {
        Intent(this, RegisterActivity::class.java).apply { startActivity(this) }
    }

    fun loginButtonClicked()
    {
        Intent(this, LoginActivity::class.java).apply { startActivity(this) }
    }
}