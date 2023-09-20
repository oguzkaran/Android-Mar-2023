package org.csystem.android.activity.viewmodel

import java.io.Serializable
import java.time.LocalDateTime

data class LoginInfo(var username: String = "",
                     var password: String = "",
                     var loginDateTime: LocalDateTime? = null) : Serializable