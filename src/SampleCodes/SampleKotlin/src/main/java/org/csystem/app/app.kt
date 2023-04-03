/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki iki fonksiyonun basit bir karşılaştırması
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

fun main()
{
    println(if (isPrime(1_000_003)) "Asal" else "Asal değil")
    println(if (isPrimeSlow(1_000_003)) "Asal" else "Asal değil")
}

fun isPrimeSlow(a: Int) : Boolean
{
    if (a <= 1)
        return false

    val halfValue = a / 2

    var count = 0

    for (i in 2..halfValue) {
        ++count
        if (a % i == 0)
            return false
    }

    println("isPrimeSlow:count=$count")
    return true
}

fun isPrime(a: Long) : Boolean
{
    if (a <= 1)
        return false

    if (a % 2 == 0L)
        return a == 2L

    if (a % 3 == 0L)
        return a == 3L

    if (a % 5 == 0L)
        return a == 5L

    if (a % 7 == 0L)
        return a == 7L

    var i = 11L

    var count = 0L

    while (i * i <= a) {
        ++count
        if (a % i == 0L)
            return false

        i += 2
    }

    println("isPrime:count=$count")

    return true
}