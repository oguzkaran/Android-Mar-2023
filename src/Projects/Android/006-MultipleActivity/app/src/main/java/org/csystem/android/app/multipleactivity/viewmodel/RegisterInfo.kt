package org.csystem.android.app.multipleactivity.viewmodel

import java.time.LocalDate
import java.time.Month
import java.time.temporal.ChronoUnit

data class RegisterInfo(var firstName: String = "",
                        var middleName: String? = "",
                        var lastName: String = "", var email: String = "",
                        var password: String = "",
                        var birthDate: LocalDate = LocalDate.of(1995, Month.OCTOBER, 12)) {
    val age: Double
        get() = ChronoUnit.DAYS.between(birthDate, LocalDate.now()) / 365.0

    val fullName: String
        get()
        {
            var middleStr = middleName ?: "" //Elvis operatör kullanmak için bu şekilde yapıldı

            middleStr += if (middleStr.isNotEmpty()) " " else ""

            return "${"$firstName "}$middleStr$lastName"
        }
}
