package org.csystem.android.app.geonames.wikisearch.viewmodel.converter

import androidx.databinding.InverseMethod

object MaxRowStringConverter {
    @InverseMethod("toStr")
    fun toMaxRow(str: String) : Int
    {
        var result = 0
        try {
            result = str.toInt()
        }
        catch (_: NumberFormatException) {

        }

        return result
    }
    fun toStr(maxRow: Int) = maxRow.toString()
}