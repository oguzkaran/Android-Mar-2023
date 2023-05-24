package org.csystem.util.numeric

import kotlin.math.abs
import kotlin.math.log10
import kotlin.math.pow

private val g_onesTR = arrayOf("", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz")
private val g_tensTR = arrayOf("", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan")

private fun Int.getDigitsPowSum() : Int
{
    var temp = this
    val digitCount = countDigits()
    var total = 0

    while (temp != 0) {
        total += (temp % 10).toDouble().pow(digitCount.toDouble()).toInt()
        temp /= 10
    }

    return total
}

private fun numToStr3DigitsTR(a: Int, b: Int, c: Int, sb: StringBuilder)
{
    if (a != 0) {
        if (a != 1)
            sb.append(g_onesTR[a])
        sb.append("yüz")
    }

    sb.append(g_tensTR[b])
    sb.append(g_onesTR[c])
}

fun Int.numToStr3DigitsTR() : String
{
    val sb = StringBuilder()

    sb.append(if (this < 0) "eksi" else "")
    val temp = abs(this)

    numToStr3DigitsTR(temp / 100, temp % 100 / 10, temp % 10, sb)

    return sb.toString()
}

fun Int.countDigits() = this.toLong().countDigits()

fun Long.countDigits() = if (this == 0L) 1 else log10(abs(this).toDouble()).toInt() + 1


fun Long.digits() : IntArray
{
    val d = IntArray(countDigits())
    var temp = abs(this)

    for (i in d.size - 1 downTo 0) {
        d[i] = (temp % 10).toInt()
        temp /= 10
    }

    return d
}

fun Long.digitsInThrees() : IntArray
{
    TODO()
}

fun Int.digitsInThrees() = this.toLong().digitsInThrees()


fun Int.digits() = this.toLong().digits()

fun Int.isArmstrong() = this >= 0 && getDigitsPowSum() == this

fun Long.isPrime() : Boolean
{
    if (this <= 1)
        return false

    if (this % 2 == 0L)
        return this == 2L

    if (this % 3 == 0L)
        return this == 3L

    if (this % 5 == 0L)
        return this == 5L

    if (this % 7 == 0L)
        return this == 7L

    var i = 11L

    while (i * i <= this) {
        if (this % i == 0L)
            return false
        i += 2
    }

    return true
}


