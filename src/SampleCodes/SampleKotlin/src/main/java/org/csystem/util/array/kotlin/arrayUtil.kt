package org.csystem.util.array.kotlin

import kotlin.random.Random

fun Random.randomIntArray(count: Int, min: Int, bound: Int) : IntArray
{
    val a = IntArray(count)

    for (i in a.indices)
        a[i] = this.nextInt(min, bound)

    return a
}

fun IntArray.write(count: Int = this.size, n: Int = 1)
{
    val fmt = "%%0%dd ".format(n)

    for (i in 0 until count)
        print(fmt.format(this[i]))

    println()
}

fun IntArray.write(n: Int = 1) = this.write(this.size, n)

fun <T> Array<T>.write(count: Int = this.size)
{
    for (i in 0 until count)
        println(this[i])
}
