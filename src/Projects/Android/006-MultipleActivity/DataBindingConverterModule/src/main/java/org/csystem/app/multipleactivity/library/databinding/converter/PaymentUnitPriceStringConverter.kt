package org.csystem.app.multipleactivity.library.databinding.converter

import androidx.databinding.InverseMethod

object PaymentUnitPriceStringConverter {
    private var mFail = false

    val fail: Boolean
        get() = mFail

    var failStr = ""

    @InverseMethod("toStr")
    @JvmStatic
    fun toDouble(str: String) : Double
    {
        var result = 0.0

        try {
            mFail = false
            result = str.toDouble();
        }
        catch (ignore: NumberFormatException) {
            mFail = true;
        }

        return result
    }

    @JvmStatic
    fun toStr(unitPrice: Double) = unitPrice.toString()
}