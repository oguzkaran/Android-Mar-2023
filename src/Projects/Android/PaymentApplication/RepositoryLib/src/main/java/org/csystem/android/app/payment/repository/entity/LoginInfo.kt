package org.csystem.android.app.payment.repository.entity

import java.time.LocalDateTime

data class LoginInfo(var id: Long, var userName: String, var loginDateTime: LocalDateTime)