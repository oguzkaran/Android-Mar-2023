package org.csystem.android.app.payment.data.service.dto

import java.io.Serializable

data class LoginInfoDTO(var username: String = "",
                        var password: String = "",
                        var success: Boolean = true,
                        var loginDateTimeStr: String = "") : Serializable