/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki demo örnekte runBlocking scope içerisinde coroutine yaratılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.csystem.util.console.kotlin.readInt
import kotlin.random.Random

suspend fun main() = run().apply { println("run çağrıldı") }.join()


fun doJob() = runBlocking {
    var total = 0
    val count = readInt("Input a number:")

    val job = launch { //runBlocking scope: runBlocking fonksiyonunun callback fonksiyonuna ilişkin scope
        for (i in 1..count) {
            val value = Random.nextInt(100)
            print("$value ")
            total += value
            delay(Random.nextLong(1, 1000))
        }
        println()
    }

    job.join()
    println("Total:$total")
}

fun run() = GlobalScope.launch {
    doJob()
}
