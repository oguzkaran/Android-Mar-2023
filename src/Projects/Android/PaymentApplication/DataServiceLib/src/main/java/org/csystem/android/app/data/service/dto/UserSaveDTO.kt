package org.csystem.android.app.data.service.dto

import java.io.Serializable
import java.time.LocalDate

data class UserSaveDTO(val username: String, val password: String,
                       val firstName: String, val lastName: String,
                       val birthDate: LocalDate, val middleName: String? = null) : Serializable