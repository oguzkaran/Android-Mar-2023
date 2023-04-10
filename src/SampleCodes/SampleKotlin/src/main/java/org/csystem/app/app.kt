/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Parametresi ile aldığı Int türden bir n sayısı için n-inci asal sayıyı döndüren getPrime isimli
    fonksiyonu yazınız ve aşağıdaki kod ile test ediniz. Fonksiyon n'nin pozitif olmayabn değerleri için kontrol
    yapmayacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

fun main() = runGetPrimeTest()

fun runGetPrimeTest()
{
    while (true) {
        print("Bir sayı giriniz:")
        val n = readln().toInt()

        if (n <= 0)
            break

        println("${n}. asal sayı: ${getPrime(n)}")
    }

    println("Tekrar yapıyor musunuz?")
}

fun getPrime(n: Int) : Long
{
    TODO()
}


fun isPrime(value: Long) : Boolean
{
    if (value <= 1)
        return false

    if (value % 2 == 0L)
        return value == 2L

    if (value % 3 == 0L)
        return value == 3L

    if (value % 5 == 0L)
        return value == 5L

    if (value % 7 == 0L)
        return value == 7L

    var i = 11L

    while (i * i <= value) {
        if (value % i == 0L)
            return false
        i += 2
    }

    return true
}
