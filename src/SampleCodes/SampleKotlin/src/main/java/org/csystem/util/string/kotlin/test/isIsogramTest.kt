package org.csystem.util.string.kotlin.test

import org.csystem.util.console.kotlin.readString
import org.csystem.util.string.kotlin.isIsogramEN
import org.csystem.util.string.kotlin.isIsogramTR

fun main() = runIsIsogramTest()

fun runIsIsogramTest()
{
    runIsIsogramTRTest()
    runIsIsogramENTest()
    println("Tekrar yapıyor musunuz?")
}


fun runIsIsogramTRTest()
{
    while (true) {
        val s = readString("Bir yazı giriniz:")
        if ("elma" == s)
            break

        println(if (isIsogramTR(s)) "Isogram" else "Isogram değil")
    }
}

fun runIsIsogramENTest()
{
    while (true) {
        val s = readString("Enter a text:")
        if ("quit" == s)
            break
        println(if (isIsogramEN(s)) "Isogram" else "Not an isogram")
    }
}
