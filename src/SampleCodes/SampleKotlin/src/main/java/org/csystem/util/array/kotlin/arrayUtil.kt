package org.csystem.util.array.kotlin

import kotlin.random.Random

fun Random.randomIntArray(count: Int, min: Int, bound: Int) : IntArray
{
    val a = IntArray(count)

    for (i in a.indices)
        a[i] = this.nextInt(min, bound)

    return a
}

fun IntArray.write(n: Int = 1)
{
    val fmt = "%%0%dd ".format(n)

    for (value in this)
        print(fmt.format(value))

    println()
}
