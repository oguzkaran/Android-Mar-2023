/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışnası: Parametresi ile aldığı bir yazının büyük harfleri küçük, küçük harleri büyük harf yapılmış ve geri
    kalan karakteler aynı olacak şekilde yeni bir yazıya geri dönen changeCase isimli fonksiyonu yazınız ve aşağıdaki
    kod ile test ediniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

fun main() = runChangeCaseTest()

fun runChangeCaseTest()
{
    while (true) {
        print("Input text:")
        val s = readln()

        if (s == "quit")
            break

        val str = changeCase(s)

        println("($str)")
    }
}
fun changeCase(s: String) : String
{
    TODO()
}