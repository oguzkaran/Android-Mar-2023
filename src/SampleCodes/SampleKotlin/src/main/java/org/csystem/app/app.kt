/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Parametresi ile aldığı iki yazıdan birincisi içerisinde ikincisinden kaç tane olduğunu döndüren
    countString isimli fonksiyonu ignoreCase parametresi de içerecek şekilde yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import kotlin.random.Random

fun main() = runCountStringTest()


fun runCountStringTest()
{
    while (true) {
        print("Input the first text:")
        val s1 = readln()

        print("Input the second text:")
        val s2 = readln()

        val ignoreCase = Random.nextBoolean()

        println(if (ignoreCase) "case insensitive" else "case sensitive")
        println("Count:${countString(s1, s2, ignoreCase)}")
    }
}

fun countString(s1: String, s2: String, ignoreCase: Boolean = false) : Int
{
    TODO()
}
