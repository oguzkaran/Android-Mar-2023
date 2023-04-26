package org.csystem.util.array.kotlin.test

import org.csystem.util.array.kotlin.randomIntArray
import org.csystem.util.array.kotlin.write
import org.csystem.util.console.kotlin.readInt

fun main() = runRandomIntArrayTest()

fun runRandomIntArrayTest()
{
    while (true) {
        val count = readInt("Dizinin eleman sayısını giriniz:")

        if (count <= 0)
            break
        val a = randomIntArray(count, 0, 100)

        write(2, a)
    }

    println("Tekrar yapıyor musunuz?")
}