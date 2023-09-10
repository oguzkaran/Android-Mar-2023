package org.csystem.android.app.app.hilt.datetime

import org.csystem.android.util.datetime.di.module.annotation.SystemLocalTimeInterceptor
import org.csystem.android.util.datetime.di.module.formatter.annotation.LocalTimeFormatterInterceptor
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class TimeInfo @Inject constructor() {
    @Inject
    @SystemLocalTimeInterceptor
    lateinit var time: LocalTime

    @Inject
    @LocalTimeFormatterInterceptor
    lateinit var formatter: DateTimeFormatter

    override fun toString(): String = formatter.format(time)
}