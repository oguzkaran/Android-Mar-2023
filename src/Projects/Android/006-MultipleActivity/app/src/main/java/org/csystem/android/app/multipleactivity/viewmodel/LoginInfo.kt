package org.csystem.android.app.multipleactivity.viewmodel

import java.io.Serializable
import java.time.LocalDateTime

data class LoginInfo(var username: String = "",
                     var password: String = "",
                     var loginDateTime: LocalDateTime? = null) : Serializable