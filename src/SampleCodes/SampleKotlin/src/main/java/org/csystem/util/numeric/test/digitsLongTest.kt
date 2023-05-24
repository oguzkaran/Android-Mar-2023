package org.csystem.util.numeric.test

import org.csystem.util.array.kotlin.write
import org.csystem.util.console.kotlin.readInt
import org.csystem.util.numeric.digits
import kotlin.random.Random

fun main() = runDigitsLongTest()

fun runDigitsLongTest()
{
    val count = readInt("Bir sayı giriniz:")

    for (i in 1..count) {
        val value = Random.nextLong();
        print("$value -> ")
        value.digits().write()
    }

    println("Tekrar yapıyor musunuz?")
}