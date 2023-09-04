package org.csystem.android.app.hillt.datetime

import org.csystem.android.util.datetime.di.module.annotation.SystemLocalDateInterceptor
import org.csystem.android.util.datetime.di.module.formatter.annotation.LocalDateFormatterInterceptor
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class DateInfo @Inject constructor() {
    @Inject
    @SystemLocalDateInterceptor
    lateinit var date: LocalDate

    @Inject
    @LocalDateFormatterInterceptor
    lateinit var formatter: DateTimeFormatter

    override fun toString(): String = formatter.format(date)
}