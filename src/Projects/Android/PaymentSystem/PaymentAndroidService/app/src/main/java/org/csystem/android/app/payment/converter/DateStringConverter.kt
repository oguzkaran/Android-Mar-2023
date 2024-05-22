package org.csystem.android.app.payment.converter

import androidx.databinding.InverseMethod
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

object DateStringConverter {
    @InverseMethod("toStr")
    fun toLocalDate(str: String) : LocalDate
    {
        var result = LocalDate.now()

        try {
            result = LocalDate.parse(str, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        catch (_: DateTimeParseException) {

        }

        return result;
    }

    fun toStr(date: LocalDate) : String = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(date)
}