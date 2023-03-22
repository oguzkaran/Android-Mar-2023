/*----------------------------------------------------------------------------------------------------------------------
    Kotlin 1.6 ile birlikte klavyeden enter basılana kadar girilen yazıyı bir String olarak okuyan readln fonkiyonu
    eklenmiştir
----------------------------------------------------------------------------------------------------------------------*/
package csd

fun main()
{
    print("Bir sayı giriniz:")
    val a = readln().toInt()

    println("${a * a}")
}