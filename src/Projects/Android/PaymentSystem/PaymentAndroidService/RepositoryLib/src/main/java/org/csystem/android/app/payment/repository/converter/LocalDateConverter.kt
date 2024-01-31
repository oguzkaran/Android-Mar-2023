package org.csystem.android.app.payment.repository.converter

import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

class LocalDateConverter {
    @TypeConverter
    fun toLocalDate(milliseconds: Long) : LocalDate
    {
        return Instant.ofEpochMilli(milliseconds).atZone(ZoneId.systemDefault()).toLocalDate()
    }

    @TypeConverter
    fun toMilliseconds(localDate: LocalDate) : Long
    {
        return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()
    }
}