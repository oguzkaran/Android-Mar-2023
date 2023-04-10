/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Klavyeden alınan a ve b Int türden değerleri için [a, b] aralığında tek ve çift sayıları
    ayrı ayrı toplayan programı yazınız.
    Örnekte isEven fonksiyonun "capture" yaptığına dikkat ediniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

fun main() = runApplication()

fun runApplication()
{
    print("a?")
    val a = readln().toInt()

    print("b?")
    val b = readln().toInt()

    findTotals(a, b)
}

fun findTotals(a: Int, b: Int)
{
    var evenTotal = 0
    var oddTotal = 0

    for (n in a..b) {
        fun isEven() = n % 2 == 0

        if (isEven())
            evenTotal += n
        else
            oddTotal += n
    }

    print("Çift sayıların toplamı:$evenTotal")
    print("Tek sayıların toplamı:$oddTotal")
}