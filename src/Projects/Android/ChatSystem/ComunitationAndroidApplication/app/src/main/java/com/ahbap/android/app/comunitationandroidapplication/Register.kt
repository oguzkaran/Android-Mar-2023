package com.ahbap.android.app.comunitationandroidapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.ahbap.android.app.comunitationandroidapplication.databinding.ActivityMainBinding
import com.ahbap.android.app.comunitationandroidapplication.databinding.ActivityRegisterBinding
import com.ahbap.android.app.comunitationandroidapplication.register.User
import com.ahbap.android.app.comunitationandroidapplication.register.view.ActivityRegisterListener

class Register : AppCompatActivity() {
    private lateinit var mBinding : ActivityRegisterBinding

    private fun initiazlie()
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
        initiazlie()
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