package org.csystem.android.app.multipleactivity.binding

import androidx.databinding.InverseMethod

object PaymentQuantityStringConverter {
    private var mFail = false

    val fail: Boolean
        get() = mFail

    var failStr = ""

    @InverseMethod("toStr")
    @JvmStatic
    fun toInt(str: String) : Int
    {
        var result = 0
        try {
            mFail = false
            result = str.toInt();
        }
        catch (ignore: NumberFormatException) {
            mFail = true
        }

        return result
    }
    @JvmStatic
    fun toStr(quantity: Int) = quantity.toString()
}