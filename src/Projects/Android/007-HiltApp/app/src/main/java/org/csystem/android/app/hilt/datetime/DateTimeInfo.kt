package org.csystem.android.app.hilt.datetime

import android.content.Context
import android.widget.Toast
import dagger.hilt.android.qualifiers.ActivityContext
import org.csystem.android.util.datetime.di.module.annotation.SystemLocalDateTimeInterceptor
import org.csystem.android.util.datetime.di.module.formatter.annotation.LocalDateTimeFormatterInterceptor
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class DateTimeInfo @Inject constructor(
    @LocalDateTimeFormatterInterceptor val formatter: DateTimeFormatter,
    @SystemLocalDateTimeInterceptor var dateTime: LocalDateTime,
    @ActivityContext var context: Context)  {
    init {
        Toast.makeText(context, "DateTimeInfo created -> $this", Toast.LENGTH_LONG).show()
    }
    override fun toString(): String = formatter.format(dateTime)
}