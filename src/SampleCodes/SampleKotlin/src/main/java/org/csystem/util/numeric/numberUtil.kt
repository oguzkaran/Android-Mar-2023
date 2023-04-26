package org.csystem.util.numeric

import kotlin.math.abs
import kotlin.math.log10
import kotlin.math.pow

fun getDigitsPowSum(value: Int) : Int
{
    var temp = value
    val digitCount = countDigits(value)
    var total = 0

    while (temp != 0) {
        total += (temp % 10).toDouble().pow(digitCount.toDouble()).toInt()
        temp /= 10
    }

    return total
}


fun countDigits(value: Int) = if (value == 0) 1 else log10(abs(value).toDouble()).toInt() + 1

fun isArmstrong(value: Int) = value >= 0 && getDigitsPowSum(value) == value

fun isPrime(value: Long) : Boolean
{
    if (value <= 1)
        return false

    if (value % 2 == 0L)
        return value == 2L

    if (value % 3 == 0L)
        return value == 3L

    if (value % 5 == 0L)
        return value == 5L

    if (value % 7 == 0L)
        return value == 7L

    var i = 11L

    while (i * i <= value) {
        if (value % i == 0L)
            return false
        i += 2
    }

    return true
}


