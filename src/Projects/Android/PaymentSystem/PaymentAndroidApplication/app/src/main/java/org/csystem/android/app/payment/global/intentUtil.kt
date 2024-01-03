package org.csystem.android.app.payment.global

import android.content.Intent
import org.csystem.android.app.payment.data.service.dto.LoginInfoSaveDTO
import org.csystem.android.app.payment.global.key.LOGIN_INFO

fun getLoginInfo(intent: Intent) : LoginInfoSaveDTO
{
    return if (android.os.Build.VERSION.SDK_INT < 33)
        intent.getSerializableExtra(LOGIN_INFO) as LoginInfoSaveDTO
    else
        intent.getSerializableExtra(LOGIN_INFO, LoginInfoSaveDTO::class.java)!!
}