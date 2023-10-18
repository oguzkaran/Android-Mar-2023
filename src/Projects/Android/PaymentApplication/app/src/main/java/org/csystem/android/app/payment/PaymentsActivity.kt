package org.csystem.android.app.payment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.csystem.android.app.payment.data.service.dto.LoginInfoDTO
import org.csystem.android.app.payment.global.getLoginInfo

class PaymentsActivity : AppCompatActivity() {
    private lateinit var mLoginInfo: LoginInfoDTO

    private fun initLoginInfo()
    {
        mLoginInfo =  getLoginInfo(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payments)
    }
}