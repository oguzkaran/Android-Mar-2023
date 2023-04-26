package org.csystem.util.array.kotlin

import kotlin.random.Random

fun randomIntArray(count: Int, min: Int, bound: Int, random: Random = Random) : IntArray
{
    val a = IntArray(count)

    for (i in a.indices)
        a[i] = random.nextInt(min, bound)

    return a
}

fun write(n: Int, a: IntArray)
{
    val fmt = "%%0%dd ".format(n)

    for (value in a)
        print(fmt.format(value))

    println()
}

fun write(a: IntArray) = write(1, a)