package org.csystem.util.array.kotlin.test

import org.csystem.util.array.kotlin.randomIntArray
import org.csystem.util.array.kotlin.write
import org.csystem.util.console.kotlin.readInt

fun main() = runTest()

fun runTest()
{
    val min = readInt("Minimum değeri giriniz:")
    val bound = readInt("Sınır değeri giriniz:")

    while (true) {
        val count = readInt("Dizinin eleman sayısını giriniz:")

        if (count <= 0)
            break
        val a = randomIntArray(count, min, bound)

        for (value in a)
            print("$value ")
        println()
        write(a)
    }

    println("Tekrar yapıyor musunuz?")
}