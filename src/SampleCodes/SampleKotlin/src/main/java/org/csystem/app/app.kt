/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki örnek için filter fonksiyonları ayrı ayrı da çağrılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import org.csystem.test.data.loadProductsFromFileAsIterable
import org.csystem.util.console.kotlin.readBigDecimal

fun main()
{
    try {
        val products = loadProductsFromFileAsIterable("products-withheader.csv")
        val minPrice = readBigDecimal("Minimum fiyatı giriniz:")
        val maxPrice = readBigDecimal("Maximum fiyatı giriniz:")

        //products.forEach(::println)
        println("Filtered Products:")
        products.filter { it.stock > 0}.filter{ minPrice < it.price }.filter {it.price < maxPrice }.forEach(::println)
    }
    catch (ex: Throwable) {
        println(ex.message)
    }
}

