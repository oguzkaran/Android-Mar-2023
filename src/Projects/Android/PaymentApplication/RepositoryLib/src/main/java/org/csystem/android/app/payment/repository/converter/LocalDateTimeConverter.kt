package org.csystem.android.app.payment.repository.converter

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class LocalDateTimeConverter {
    @TypeConverter
    fun toLocalDateTime(str: String) : LocalDateTime = LocalDateTime.parse(str, DateTimeFormatter.ISO_LOCAL_DATE_TIME)

    @TypeConverter
    fun toStr(localDateTime: LocalDateTime) : String = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(localDateTime)
}