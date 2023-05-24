package org.csystem.util.string.kotlin

import kotlin.random.Random

fun String.changeCase() : String
{
    val sb = StringBuilder(this.length)

    for (c in this)
        if (c.isUpperCase())
            sb.append(c.lowercaseChar())
        else
            sb.append(c.uppercaseChar())

    return sb.toString()
}


fun String.getFirstLongestPalindrome() : String
{
    TODO()
}

fun String.getLastLongestPalindrome() : String
{
    TODO()
}

fun String.getFirstShortestPalindrome() : String
{
    TODO()
}

fun String.getLastShortestPalindrome() : String
{
    TODO()
}

fun Random.getRandomTextEN(count: Int) : String
{
    var str = ""

    for (i in 1..count)
        str += (if (this.nextBoolean()) 'A' else 'a') + this.nextInt(26)

    return str;
}

fun String.isIsogram(alphabet: String) : Boolean
{
    TODO()
}

fun isIsogramTR(s: String) = s.isIsogram("abcçdefgğhıijklmnoöprsştuüvyz")

fun isIsogramEN(s: String) = s.isIsogram("abcdefghijklmnopqrstuvwxyz")

fun String.isPalindrome() : Boolean
{
    TODO()
}

fun String.isPangramTR() = this.isPangram("abcçdefgğhıijklmnoöprsştuüvyz")

fun String.isPangramEN() = this.isPangram("abcdefghijklmnopqrstuvwxyz")

fun String.isPangram( alphabet: String) : Boolean
{
    for (c in alphabet)
        if (!this.contains(c, true))
            return false

    return true
}