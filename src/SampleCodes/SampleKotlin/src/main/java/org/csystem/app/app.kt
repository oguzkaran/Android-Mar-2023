/*----------------------------------------------------------------------------------------------------------------------
    String sınıfının tüm karakterleri for döngüsü ile elde edilebilir. Yani String sınıfı "iterable"'dır. Iterable kavramı
    ileride ele alınacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

fun main()
{
    print("Bir yazı giriniz:")
    val s = readln()

    for (ch in s)
        print("$ch ")

    println()
}
