package org.csystem.android.app.generator.random.viewmodel.converter

import androidx.databinding.InverseMethod

object PeriodStringConverter {
    @InverseMethod("toStr")
    fun toPeriod(str: String) : Long
    {
        var result = 0L

        try {
            result = str.toULong().toLong();
        }
        catch (_: NumberFormatException) {

        }

        return result
    }

    fun toStr(value: Long) = value.toString()
}