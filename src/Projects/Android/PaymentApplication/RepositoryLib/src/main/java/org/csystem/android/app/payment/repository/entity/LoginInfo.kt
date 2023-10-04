package org.csystem.android.app.payment.repository.entity

import java.io.Serializable
import java.time.LocalDateTime

data class LoginInfo(var id: Long = 0, var username: String = "", var password: String = "",
                     var success: Boolean = true,
                     var loginDateTime: LocalDateTime = LocalDateTime.now()) : Serializable