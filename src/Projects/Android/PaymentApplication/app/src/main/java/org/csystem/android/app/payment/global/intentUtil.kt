package org.csystem.android.app.payment.global

import android.content.Intent
import org.csystem.android.app.payment.data.service.dto.LoginInfoDTO
import org.csystem.android.app.payment.global.key.LOGIN_INFO

fun getLoginInfo(intent: Intent) : LoginInfoDTO
{
    return if (android.os.Build.VERSION.SDK_INT < 33)
        intent.getSerializableExtra(LOGIN_INFO) as LoginInfoDTO
    else
        intent.getSerializableExtra(LOGIN_INFO, LoginInfoDTO::class.java)!!
}