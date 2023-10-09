package org.csystem.android.app.data.service.dto

import java.io.Serializable

data class LoginInfoStatusDTO(var username: String = "", var password: String = "",
                              var success: Boolean = true,
                              var loginDateTimeStr: String) : Serializable {
    override fun toString() = "Login Date Time:$loginDateTimeStr, Status:${if (success) "Success" else "Fail"}"
}