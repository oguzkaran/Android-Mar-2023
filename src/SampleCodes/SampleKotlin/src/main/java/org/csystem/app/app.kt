/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Parametresi ile aldığı Int türden bir sayının basamak sayısını döndüren countDigits isimli
    fonksiyonu döngü kullanarak yazınız yazınız ve aşağıdaki kod ile test ediniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

fun main() = runApplication()

fun runApplication()
{
    while (true) {
        print("Bir sayı giriniz:")
        val value = readln().toInt()

        println("$value sayısının bsamak sayısı:${countDigits(value)}")

        if (value == 0)
            break
    }
}

fun countDigits(value: Int) : Int
{
    TODO("Write this function")
}