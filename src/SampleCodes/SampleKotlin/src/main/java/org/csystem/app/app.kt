/*----------------------------------------------------------------------------------------------------------------------
    Dizilerin indices property elemanı [0, size) aralığında bir IntRange referansına döner:
    Eşdeğer bir döngü:
        for (i in 0 until a.size)
        a[i] *= a[i]
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

fun main()
{
    val a = arrayOf(10, 20, 30)

    for (i in a.indices)
        a[i] *= a[i];

    for (value in a)
        print("$value ")

    println()
}
