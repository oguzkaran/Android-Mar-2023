/*----------------------------------------------------------------------------------------------------------------------
    Anahtar Notlar: java.util paketindeki Random sınıfıyla kotlin.random paketindeki Random object'inin içsel algoritmaları
    aynı olmak zorunda değildir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import kotlin.random.Random

fun main()
{
    print("Tohum değerini giriniz:")
    val seed = readln().toLong()
    val r = Random(seed)
    val rj = java.util.Random(seed)

    for (i in 1..10)
        print("${r.nextInt(99) + 1} ")

    println()

    for (i in 1..10)
        print("${rj.nextInt(99) + 1} ")

    println()
}
