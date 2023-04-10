/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Klavyeden katsayıları girilen ikinci dereceden bir denklemin köklerini bulan programı yazınız.
    Açıklamalar:
        - if expression yerine when expression kullanılacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

fun main() = runApp()

fun runApp()
{
    print("a?")
    val a = readln().toDouble()

    print("b?")
    val b = readln().toDouble()

    print("c?")
    val c = readln().toDouble()

    println(findRoots(a, b, c))
}

fun calculateDelta(a: Double, b: Double, c: Double) = b * b - 4 * a * c

fun findRoots(a: Double, b: Double, c: Double) : String
{
    val delta = calculateDelta(a, b, c)

    fun calculateRoots() : String
    {
        val sqrtDelta = Math.sqrt(delta)
        return "x1 = ${(-b + sqrtDelta) / (2 * a)}, x2 = ${(-b - sqrtDelta) / (2 * a)}"
    }

    return if (delta > 0)
        calculateRoots()
    else if (delta == 0.0)
        "x1 = x2 = ${-b / (2 * a)}"
    else
        "No real root"
}
