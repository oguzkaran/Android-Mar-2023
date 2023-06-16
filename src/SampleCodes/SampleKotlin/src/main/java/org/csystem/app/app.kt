/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte printCollatz fonksiyonunun generateSequence ile yazıldığına dikkat ediniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import org.csystem.util.console.kotlin.readInt

fun main() = generateSequence { readInt("Bir sayı giriniz:") }.takeWhile {it > 0}.forEach { printCollatz(it) }

fun printCollatz(value: Int)
{
    var a = value

    generateSequence(a) { a = when { a % 2 == 0 -> a / 2 else ->  3 * a + 1}; a }
        .takeWhile{a > 1}
        .forEach{print("$it ")}
    println(1)
}
