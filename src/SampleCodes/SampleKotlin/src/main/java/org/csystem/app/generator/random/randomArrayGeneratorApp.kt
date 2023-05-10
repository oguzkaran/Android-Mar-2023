package org.csystem.app.generator.random

import org.csystem.generator.random.createRandomAnyArray
import org.csystem.math.geometry.Circle
import org.csystem.math.geometry.Point
import org.csystem.util.console.kotlin.readInt

fun main() = runApplication()

fun runApplication()
{
    val count = readInt("Bir sayı giriniz:")
    val any = createRandomAnyArray(count)

    for (a in any) {
        println("----------------------------------")
        println(a.javaClass.name)

        when (a) {
            is String -> println("$a -> ${a.uppercase()}")
            is Int -> println("$a * $a = ${a * a}")
            is Point -> println("(${a.x}, ${a.y})")
            is Boolean -> println("flag = $a, !flag = ${!a}")
            is Circle -> println("Radius:${a.radius}, Area:${a.area}, Perimeter:${a.circumference}")
        }

        println("----------------------------------")
    }
}
