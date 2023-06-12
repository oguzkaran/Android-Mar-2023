/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte stokta bulunmayan ürün varsa listelenmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import org.csystem.data.source.loadDefaultProductsAsArrays

fun main()
{
    try {
        val products = loadDefaultProductsAsArrays()

        if (products.any {it.stock <= 0}) {
            println("Stokta olmayan ürünler:")
            products.filter {it.stock <= 0}.forEach(::println)
        }
        else
            println("Her ürün stokta var")
    }
    catch (ex: Throwable) {
        println(ex.message)
        ex.printStackTrace()
    }
}
