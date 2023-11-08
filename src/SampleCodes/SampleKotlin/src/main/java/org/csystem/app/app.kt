/*----------------------------------------------------------------------------------------------------------------------
    Thread havuzları ve Excutors:
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import kotlin.concurrent.thread
import kotlin.random.Random

fun threadCallback()
{
    val self = Thread.currentThread()
    var sum = 0L

    while (!Thread.interrupted()) {
        val value = Random.nextInt()
        println(value)
        sum += value
    }

    println("Sum first = $sum")

    while (!self.isInterrupted) {
        val value = Random.nextInt()
        println(value)
        sum += value
    }

    println("Sum last = $sum")
}

fun main()
{
    thread(block = ::threadCallback).apply { join(3000); interrupt(); join(1000); interrupt()}
}


