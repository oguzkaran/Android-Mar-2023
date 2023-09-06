package org.csystem.android.app.hilt.datetime

import org.csystem.android.util.datetime.di.module.annotation.SystemLocalDateTimeInterceptor
import org.csystem.android.util.datetime.di.module.formatter.annotation.LocalDateTimeFormatterInterceptor
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class DateTimeInfo @Inject constructor(@LocalDateTimeFormatterInterceptor val formatter: DateTimeFormatter,
    @SystemLocalDateTimeInterceptor var dateTime: LocalDateTime)  {
    override fun toString(): String = formatter.format(dateTime)
}