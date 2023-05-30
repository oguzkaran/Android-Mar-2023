/*----------------------------------------------------------------------------------------------------------------------
    use extension fonksiyonu. Bu, aslında Java'daki try-with-resources deyiminin Kotlin'deki karşılığıdır. Aşağıdaki
    kodun Java karşılığı:

    try (Sample s = new Sample()) {
        s.foo(-10);
    }
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import java.io.Closeable
import java.lang.IllegalArgumentException
import kotlin.random.Random

fun main()
{
    val s = Sample()

    try {
        s.use {
            s.foo(Random.nextInt(-10, 10))
        }
    }
    catch (ex: IllegalArgumentException) {
        println(ex.message)
    }
}

class Sample : Closeable {
    fun foo(a: Int) {
        if (a < 0)
            throw IllegalArgumentException("a must be positive")

        println("foo")
    }
    override fun close()
    {
        println("close")
    }
}
