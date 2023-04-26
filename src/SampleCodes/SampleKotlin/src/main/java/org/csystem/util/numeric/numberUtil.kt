package org.csystem.util.numeric

import kotlin.math.abs
import kotlin.math.log10
import kotlin.math.pow

val g_onesTR = arrayOf("", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz")
val g_tensTR = arrayOf("", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan")

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

fun numToStr3DigitsTR(a: Int, b: Int, c: Int, sb: StringBuilder)
{
    if (a != 0) {
        if (a != 1)
            sb.append(g_onesTR[a])
        sb.append("yüz")
    }

    sb.append(g_tensTR[b])
    sb.append(g_onesTR[c])
}

fun numToStr3DigitsTR(value: Int) : String
{
    val sb = StringBuilder()

    sb.append(if (value < 0) "eksi" else "")
    val temp = abs(value)

    numToStr3DigitsTR(temp / 100, temp % 100 / 10, temp % 10, sb)

    return sb.toString()
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

fun digitsInThrees(value: Long) : IntArray
{
    TODO()
}

fun digitsInThrees(value: Int) = digitsInThrees(value.toLong())


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


