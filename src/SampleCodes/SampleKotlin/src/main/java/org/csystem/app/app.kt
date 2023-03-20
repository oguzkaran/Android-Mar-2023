/*----------------------------------------------------------------------------------------------------------------------
    Bir fonksiyonu çağıran fonksiyon (caller) ile çağrılan fonksiyon (callee) aynı pakette ise paket ismi kullanılmasa
    da olur. Yani aynı .kt uzantılı dosyada bulunan veya farklı dosyada fakat aynı paket altında bulunan fonksiyonlar
    doğrudan çağrılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

fun main()
{
    val a: Int = 10
    val b: Int = 20
    val c = a.plus(b)

    println("Hello, World")
    foo()
    println("Goodbye, World")
}

fun foo()
{
    println("foo")
    bar()
}


fun bar()
{
    println("bar")
}


