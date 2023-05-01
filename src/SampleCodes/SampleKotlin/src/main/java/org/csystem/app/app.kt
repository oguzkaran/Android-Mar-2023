/*----------------------------------------------------------------------------------------------------------------------
    enum'ların eşitlik karşılaştırması == veya === operatörü ile yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import org.csystem.util.console.kotlin.readInt
import kotlin.random.Random

private val g_colors = Color.values()

fun main() = runRandomColorGenerator()

fun runRandomColorGenerator()
{
    val count = readInt("Kaç tane renk üretmek istersiniz:")

    for (i in 1..count) {
        val c1 = getRandomColor()
        val c2 = getRandomColor()

        println("---------------------------------------------------------------")
        println("$c1: r = ${c1.r}, g = ${c1.g}, b = ${c1.b}")
        println("$c2: r = ${c2.r}, g = ${c2.g}, b = ${c2.b}")
        println(if (c1 === c2) "Aynı renk" else "Farklı renkler")
        println(if (c1 == c2) "Aynı renk" else "Farklı renkler")
        println("---------------------------------------------------------------")
    }
}

fun getRandomColor() = g_colors[Random.nextInt(g_colors.size)]

enum class Color(val r: Int = 0, val g: Int = 0, val b: Int = 0) {
    RED(255), GREEN(g = 255), BLUE(b = 255), WHITE(255, 255, 255), BLACK
}
