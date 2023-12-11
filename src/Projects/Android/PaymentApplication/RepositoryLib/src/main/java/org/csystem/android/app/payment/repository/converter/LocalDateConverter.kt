package org.csystem.android.app.payment.repository.converter

import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class LocalDateConverter {
    @TypeConverter
    fun toLocalDate(str: String) : LocalDate = LocalDate.parse(str, DateTimeFormatter.ISO_DATE)

    @TypeConverter
    fun toStr(localDate: LocalDate) : String = DateTimeFormatter.ISO_DATE.format(localDate)
}