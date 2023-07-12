package org.csystem.android.app.basicviews.viewmodel

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

data class RegisterInfo(var name: String, var email: String, var birthDate: LocalDate) {
    private val mFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val age: Double
        get() = ChronoUnit.DAYS.between(birthDate, LocalDate.now()) / 365.0

    override fun toString() = "$name, $email, ${mFormatter.format(birthDate)}, $age"
}