/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte display fonskiyonu çağrısında K türü tespit edilemez
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

fun main()
{
    val a = "ankara"
    val b = 10

    display<String, Ibt>(a) //error
}

fun <T, K> display(t: T) : K?
{
    println(t)

    return null
}
