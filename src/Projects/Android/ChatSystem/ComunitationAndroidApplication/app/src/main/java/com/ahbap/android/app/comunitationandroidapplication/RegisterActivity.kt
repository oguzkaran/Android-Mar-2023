package com.ahbap.android.app.comunitationandroidapplication

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ahbap.android.app.comunitationandroidapplication.databinding.ActivityRegisterBinding
import com.ahbap.android.app.comunitationandroidapplication.register.User
import com.ahbap.android.app.comunitationandroidapplication.register.view.ActivityRegisterListener

class RegisterActivity : AppCompatActivity() {
    private lateinit var mBinding : ActivityRegisterBinding

    private fun initialize()
    {
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_register)
        mBinding.view = ActivityRegisterListener(this)
        mBinding.user = User()

    }
    private fun AlertPass()
    {
        AlertDialog.Builder(this)
            .setTitle("Warning")
            .setMessage("Şifreler uyuşmuyor")
            .setNeutralButton("ok"){_,_->}
            .create()
            .show()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()
    }


    fun RegisterButton()
    {
        if (mBinding.user!!.password != mBinding.user!!.confirmedPassword)
        {
            AlertPass()
            return
        }

    }
}