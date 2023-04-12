/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Klavyeden sıfır girilene kadar alınan Int türden sayıların ortalamasını bulup ekrana yazdıran
    programı yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

fun main() = runAverageApplication()

fun runAverageApplication()
{
    var sum = 0
    var count = 0
    println("Sayıları girmeye başlayınız:")

    while (true) {
        val a = readln().toInt()

        if (a == 0)
            break

        sum += a; ++count
    }

    println("Ortalama:${sum.toDouble() / count}")
    println("Tekrar yapıyor musunuz?")
}

