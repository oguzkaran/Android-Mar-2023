/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Parametresi ile aldığı bir sayının basamaklarının basamak sayıncı kuvvetleri toplamının
    kendisine eşit olup olmadığını test eden isArmstrong isimli fonksiyonu yazınız ve aşağıdaki kod ile test ediniz. Fonksiyon
    negatif değerler için false değerini döndürecektir

    Açıklama: Kuvvet alma işlemi için bir önceki örnekte yazılan pow fonksiyonu kullanılacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

fun main() = runIsArmstrongTest()

fun runIsArmstrongTest()
{
    while (true) {
        print("Tabanı giriniz:")
        val a = readln().toInt()

        if (a == 0)
            break;

        print("Üssü giriniz:")
        val b = readLine()!!.toInt()

        println("pow($a, $b) = ${pow(a, b)}")
    }

    println("Tekrar yapıyor musunuz?")
}

fun isArmstrong(value: Int) : Boolean
{
    TODO("TODO")
}

fun countDigits(value: Int) : Int
{
    var count = 0
    var temp = value

    do {
        ++count
        temp /= 10
    } while (temp != 0)

    return count
}

fun pow(a: Int, b: Int) : Int
{
    var result = 1

    for (i in 1..b)
        result *= a

    return result
}
