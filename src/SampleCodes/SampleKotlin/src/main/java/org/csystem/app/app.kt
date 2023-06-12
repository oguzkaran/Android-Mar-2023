/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki örnek let ile de yapılabilirdi. Ancak okunabililik açısından also daha uygundur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import org.csystem.util.console.kotlin.readInt
import org.csystem.util.numeric.countDigits

fun main()
{
    val a: Int = readInt("Bir sayı giriniz:")

    //...

    val str = a.let { println("Number of digits:${it.countDigits()}"); "$it" }

    println(str)
}