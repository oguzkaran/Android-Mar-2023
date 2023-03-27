/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Parametresi ile aldığı 3 basamaklı Int türden bir sayının basamakları toplamını döndüren
    sum3Digits fonksiyonu ve test kodunu yazınız. Fonksiyon basamak sayısı kontrolü yapmayacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

fun main() = runSum3DigitsTest()

fun runSum3DigitsTest()
{
    print("3 basamaklı bir sayı griniz:")
    val value = readln().toInt()

    print("$value sayısının basamakları toplamı:${sum3Digits(value)}")
}

fun sum3Digits(value: Int) : Int
{
    val a = value.div(100)
    val b  = value.div(10).mod(10)
    val c = value.mod(10)

    return kotlin.math.abs(a + b + c);
}