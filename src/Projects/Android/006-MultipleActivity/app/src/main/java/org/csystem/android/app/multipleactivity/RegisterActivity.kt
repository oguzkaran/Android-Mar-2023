package org.csystem.android.app.multipleactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.csystem.android.app.multipleactivity.databinding.ActivityRegisterBinding
import org.csystem.android.app.multipleactivity.viewmodel.RegisterInfo

class RegisterActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityRegisterBinding

    private fun initViewModels()
    {
        mBinding.registerInfo = RegisterInfo()
    }

    private fun initBinding()
    {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_register)
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
    }

    fun registerButtonClicked()
    {
        TODO("Not implemented yet!...")
    }

    fun clearButtonClicked()
    {
        TODO("Not implemented yet!...")
    }

    fun closeButtonClicked()
    {
        TODO("Not implemented yet!...")
    }
}