package org.csystem.app.multipleactivity.library.databinding.converter

import androidx.databinding.InverseMethod
import org.csystem.android.util.datetime.DateTimeFormatterUtil
import java.time.LocalDate
import java.time.Month
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

object RegisterBirthDateStringConverter {
    private val mFormatter = DateTimeFormatterUtil.DATE_TIME_FORMATTER_TR;
    private var mFail = false

    val fail: Boolean
        get() = mFail

    var failStr = ""

    @InverseMethod("toStr")
    @JvmStatic
    fun toLocalDate(str: String) : LocalDate
    {
        var result = LocalDate.of(1995, Month.OCTOBER, 12)

        try {
            mFail = false
            result = LocalDate.parse(str, mFormatter)
        }
        catch (ignore: DateTimeParseException) {
            mFail = true
        }

        return result
    }

    @JvmStatic
    fun toStr(birthDate: LocalDate) = mFormatter.format(birthDate)
}