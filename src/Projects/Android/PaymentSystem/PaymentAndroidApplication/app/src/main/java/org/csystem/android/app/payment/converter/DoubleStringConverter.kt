package org.csystem.android.app.payment.converter

import androidx.databinding.InverseMethod

object DoubleStringConverter {
    @InverseMethod("toStr")
    fun toDouble(str: String) : Double
    {
        var result = 0.0

        try {
            result = str.toDouble()
            if (result < 0)
                throw NumberFormatException()
        }
        catch (_: NumberFormatException) {

        }

        return result;
    }

    fun toStr(value: Double) : String = value.toString()
}