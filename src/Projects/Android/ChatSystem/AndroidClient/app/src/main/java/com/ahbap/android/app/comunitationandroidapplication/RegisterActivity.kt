package com.ahbap.android.app.comunitationandroidapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ahbap.android.app.comunitationandroidapplication.databinding.ActivityRegisterBinding
import com.ahbap.android.app.comunitationandroidapplication.register.User
import com.ahbap.android.app.comunitationandroidapplication.register.view.ActivityRegisterListener
import com.karandev.util.net.TcpUtil
import java.io.IOException
import java.net.Socket

const val HOST = "127.0.0.1"
const val PORT = 50527

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

    private fun registerCallback()
    {
        try {
            Socket(HOST, PORT).use {
                TcpUtil.sendStringViaLength(it, mBinding.user!!.name)
                TcpUtil.sendStringViaLength(it, mBinding.user!!.nickname)
                TcpUtil.sendStringViaLength(it, mBinding.user!!.password)
                val statusMessage = TcpUtil.receiveStringViaLength(it)

                if (statusMessage == "SUC_REGISTER") {
                    Log.i("success", "Registered successfully!.... Go tp login activity")
                }
                else {
                    Log.i("fail", statusMessage)
                }

            }
        }
        catch (ex: IOException) {
            Log.d("reg-server", ex.message!!)
            //...
        }
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        initialize()
    }

    fun RegisterButton()
    {
        if (mBinding.user!!.password != mBinding.user!!.confirmedPassword) {
            AlertPass()
            return
        }

        //...
    }
}