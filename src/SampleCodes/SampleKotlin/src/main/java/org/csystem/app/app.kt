/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Parametresi ile aldığı Int türden bir sayının tersini döndüren reversed isimli fonksiyonu yazınız
    ve aşağıdaki kod ile test ediniz.
    Algoritma: 123 -> 3 -> 3 * 10 + 2 = 32 -> 32 * 10 + 1 = 321
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

fun main() = runReversedTest()

fun runReversedTest()
{
    while (true) {
        print("Bir sayı giriniz:")
        val value = readln().toInt()

        println("$value sayısının tersi:${reversed(value)}")

        if (value == 0)
            break
    }

    println("Tekrar yapıyor musunuz?")
}

fun reversed(value: Int) : Int
{
    TODO("TODO")
}