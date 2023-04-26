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

fun numToStr3DigitsTR(value: Int) : String
{
    TODO()
}

fun countDigits(value: Int) = countDigits(value.toLong())

fun countDigits(value: Long) = if (value == 0L) 1 else log10(abs(value).toDouble()).toInt() + 1


fun digits(value: Long) : IntArray
{
    val d = IntArray(countDigits(value))
    var temp = abs(value)

    for (i in d.size - 1 downTo 0) {
        d[i] = (temp % 10).toInt()
        temp /= 10
    }

    return d
}

fun digits(value: Int) = digits(value.toLong())

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


