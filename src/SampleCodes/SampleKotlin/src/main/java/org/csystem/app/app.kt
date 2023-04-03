/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Parametresi ile aldığı Int türden bir sayının basamakları toplamını döndüren sumDigits metodunu
    yazınız ve aşağıdaki kod ile test ediniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

fun main() = runCountDigitsTest()

fun runCountDigitsTest()
{
    while (true) {
        print("Bir sayı giriniz:")
        val value = readln().toInt()

        println("$value sayısının basamakları toplamı:${sumDigits(value)}")

        if (value == 0)
            break
    }

    println("Tekrar yapıyor musunuz?")
}

fun sumDigits(value: Int) : Int
{
    TODO("TODO")
}