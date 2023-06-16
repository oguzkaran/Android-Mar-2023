/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte drop ve count eklenti fonksiyonları kullanılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import org.csystem.test.data.loadNamesFromFileAsList
import org.csystem.util.console.kotlin.readInt
import org.csystem.util.console.kotlin.readString

fun main()
{
    try {
        val text = readString("Bir yazı giriniz:")
        val count = readInt("Sorgudan son kaç tanesi atılsın:")
        val allNames = loadNamesFromFileAsList("names.csv")
        val names = allNames.filter { it.contains(text, ignoreCase = true) }
            .take(count)
            .map { it.lowercase() }
            .toList()

        names.forEach(::println)
        println("Tüm koşula uygun veriler toplam ${allNames.count { it.contains(text, ignoreCase = true) }} tanedir")
    }
    catch (ex: Throwable) {
        println(ex.message)
    }
}