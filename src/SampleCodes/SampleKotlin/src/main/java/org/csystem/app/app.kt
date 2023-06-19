/*----------------------------------------------------------------------------------------------------------------------
    map tarzı colection'lar: Örnekte TreeMap kullanıldığından anahtar değerlerinin sıralanması gerekmez
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import org.csystem.test.data.loadNamesFromFileAsTreeMap

fun main()
{
    try {
        val namesMap = loadNamesFromFileAsTreeMap("nameswithkeys.csv")

        println("Size: ${namesMap.size}")

        namesMap.keys.forEach {print("$it -> "); namesMap[it]?.forEach { print("$it ") }; println()}

        println("Size: ${namesMap.size}")
    }
    catch (ex: Throwable) {
        ex.printStackTrace()
    }
}
