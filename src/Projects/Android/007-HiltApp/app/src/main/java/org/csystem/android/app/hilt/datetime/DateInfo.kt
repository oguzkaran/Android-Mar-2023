package org.csystem.android.app.hilt.datetime

import android.content.Context
import android.widget.Toast
import dagger.hilt.android.qualifiers.ActivityContext
import org.csystem.android.util.datetime.di.module.annotation.SystemLocalDateInterceptor
import org.csystem.android.util.datetime.di.module.formatter.annotation.LocalDateFormatterInterceptor
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class DateInfo @Inject constructor(@ActivityContext var context: Context,
                                   @SystemLocalDateInterceptor var date: LocalDate,
                                   @LocalDateFormatterInterceptor var formatter: DateTimeFormatter) {
    init {
        Toast.makeText(context, "DateInfo created -> $this", Toast.LENGTH_LONG).show()
    }
    override fun toString(): String =  formatter.format(date)
}