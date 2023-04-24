/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Parametresi ile aldığı bir yazının pangram olup olmadığını test eden isPangramTR ve isPangramEN
    fonksiyonlarını yazınız ve aşağıdaki kod ile test ediniz
    Açıklama: Fonksiyonlar özel isim ve cümle anlamı kontrolü yapmayacaktır
    Türkçe pangram      : Pijamalı hasta yağız şoföre çabucak güvendi
    İngilizce pangram   : The quick brown fox jumps over the lazy dog
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

fun main() = runPangramTest()

fun runPangramTest()
{
    runIsPangramTRTest()
    runIsPangramENTest()
}
fun runIsPangramTRTest()
{
    while (true) {
        print("Bir yazı giriniz:")
        val s = readln()

        if ("elma" == s)
            break

        print(if (isPangramTR(s)) "Pangram" else "Pangram değil")
    }
}

fun runIsPangramENTest()
{
    while (true) {
        print("Input a text:")
        val s = readln()

        if ("quit" == s)
            break
        print(if (isPangramEN(s)) "Pangram" else "Not a Pangram")
    }
}
fun isPangramTR(s: String) : Boolean
{
    TODO()
}

fun isPangramEN(s: String) : Boolean
{
    TODO()
}