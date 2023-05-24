/*----------------------------------------------------------------------------------------------------------------------
    MutableComplex sınıfının operatör fonksiyonları
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import org.csystem.math.random.nextMutableComplex
import kotlin.random.Random

fun main()
{
    val z1 = Random.nextMutableComplex(-10, 10)
    val value = Random.nextDouble(10.0)
    val z = z1 + value

    println(z1)
    println("value = $value")
    println(z)
}
