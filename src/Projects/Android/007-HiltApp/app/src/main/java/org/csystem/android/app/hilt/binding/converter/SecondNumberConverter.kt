package org.csystem.android.app.hilt.binding.converter

import androidx.databinding.InverseMethod
import java.lang.NumberFormatException

object SecondNumberConverter {
    @InverseMethod("toStr")
    fun toInt(str: String) =
        try {
            str.toInt()
        }
        catch (ignore: NumberFormatException) {
            0
        }

    fun toStr(a: Int) = a.toString()
}