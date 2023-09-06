package org.csystem.android.app.hilt.binding.converter

import androidx.databinding.InverseMethod
import java.lang.NumberFormatException

object FirstNumberConverter {
    @InverseMethod("toStr")
    fun toInt(str: String) : Int
    {
        var result = 0

        try {
            result = str.toInt()
        }
        catch (ignore: NumberFormatException) {

        }

        return result
    }

    fun toStr(a: Int) = a.toString()
}