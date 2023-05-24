package org.csystem.util.numeric.test

import org.csystem.util.console.kotlin.readInt
import org.csystem.util.numeric.numToStr3DigitsTR
import kotlin.random.Random

fun main() = runNumToStrTest()

fun runNumToStrTest()
{
    val count = readInt("Bir sayı giriniz:")

    for (i in 1..count) {
        val value = Random.nextInt(-999, 1000)
        println("$value -> ${value.numToStr3DigitsTR()}")
    }

    println("Tekrar yapıyor musunuz?")
}