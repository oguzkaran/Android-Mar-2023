package org.csystem.util.string.kotlin.test

import org.csystem.util.string.kotlin.isPangramEN
import org.csystem.util.string.kotlin.isPangramTR

fun main() = runIsPangramTest()

fun runIsPangramTest()
{
    runIsPangramTRTest()
    runIsPangramENTest()
}

fun runIsPangramTRTest()
{
    while (true) {
        print("Bir yazı giriniz:")
        val s = readln()

        if ("elma" == s)
            break

        println(if (s.isPangramTR()) "Pangram" else "Pangram değil")
    }
}

fun runIsPangramENTest()
{
    while (true) {
        print("Input a text:")
        val s = readln()

        if ("quit" == s)
            break

        println(if (s.isPangramEN()) "Pangram" else "Not a Pangram")
    }
}