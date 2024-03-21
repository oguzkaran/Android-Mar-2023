/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki örnek async fonksiyonu ile await kullanarak da yapılabilir. async fonksiyonu tipik Deferred<y> türünden
    bir interface referansına geri döner. Bu arayüzün await metodu ilgili coroutine beklenebilir. await metodu async
    fonksiyonuna verilen callback fonksiyonun değerine geri döner. Yani bu anlamda klasik Future<T> arayüzüne benzetilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.csystem.util.console.kotlin.readInt
import kotlin.random.Random

fun main() = doJob()

suspend fun printTotal(count: Int) = coroutineScope {
    val deferred = async {
        var result = 0
        for (i in 1..count) {
            val value = Random.nextInt(100)
            print("$value ")
            result += value
            delay(Random.nextLong(1, 1000))
        }
        println()
        result
    }

    println("Total:${deferred.await()}:")
}

fun doJob() = runBlocking {
    printTotal(readInt("Input a number:"))

}
