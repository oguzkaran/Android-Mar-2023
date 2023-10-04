package org.csystem.android.app.payment.repository.entity

import java.io.Serializable
import java.time.LocalDate

data class User(var username: String = "", var password: String = "",
                var firstName: String = "", var middleName: String? = "", var lastName: String = "",
                var birthDate: LocalDate = LocalDate.now(),
                var registerDate: LocalDate = LocalDate.now()) : Serializable {
    constructor(username: String, password: String, firstName: String, lastName: String,
                birthDate: LocalDate, registerDate: LocalDate)
    :this(username, password, firstName, null, lastName, birthDate, registerDate)
}