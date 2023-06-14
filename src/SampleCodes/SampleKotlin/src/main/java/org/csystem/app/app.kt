/*----------------------------------------------------------------------------------------------------------------------
    next metodu eleman yoksa NoSuchElementException nesnesi fırlatır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import org.csystem.util.array.kotlin.randomIntArray
import kotlin.random.Random

fun main()
{
    val a = Random.randomIntArray(10, 1, 100)
    val iter = a.iterator()

    try {
        while (true)
            print("${iter.next()} ")
    }
    catch (ex: NoSuchElementException) {
        println()
    }

    for (value in a)
        print("${value} ")

    println()
}
