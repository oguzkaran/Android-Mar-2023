/*----------------------------------------------------------------------------------------------------------------------
    joinToString fonksiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import org.csystem.util.array.kotlin.randomIntArray
import org.csystem.util.array.kotlin.write

fun main()
{
    val a = randomIntArray(10, 0, 100)

    write(2, a)

    val str = a.joinToString(prefix = "{", postfix = "}")

    println(str)
}