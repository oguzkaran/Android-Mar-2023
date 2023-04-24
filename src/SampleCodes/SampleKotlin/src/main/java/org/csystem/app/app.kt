/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Parametresi ile aldığı bir yazının baş harfini büyük geri kalan harflerini küçük yapan capitalize
    isimli fonksiyonu yazınız ve test ediniz
    Örnek: profesyonel Bir Android Programcısı olmak için çok çalışmak gerekir -> Profesyonel bir android programcısı olmak için çok çalışmak gerekir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

fun main() = runCapitalizeTest()

fun runCapitalizeTest()
{
    while (true) {
        print("Bir yazı giriniz:")
        val text = readln()

        println(capitalize(text))

        if (text == "elma")
            break
    }

    println("Tekrar yapıyor musunuz?")
}

fun capitalize(s: String) : String
{
    TODO()
}
