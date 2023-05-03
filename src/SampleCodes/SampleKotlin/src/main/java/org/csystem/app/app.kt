/*----------------------------------------------------------------------------------------------------------------------
    Bir referansın dinamik türü o referansın çalışma zamanı sırasında bellekte gösterdiği gerçek nesnenin türüdür
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import org.csystem.util.console.kotlin.readInt

fun main()
{
    while (true) {
        val value = readInt("Bir sayı giriniz:")

        if (value == 0)
            break

        val a: A

        a = if (value > 0) B() else A()

        println(a.javaClass.name) // a referansının dinamik türü stdout'a yazdırılıyor
    }
    println("Tekrar yapıyor musunuz?")
}

open class A {
    //...
}

class B : A() {
    //...
}
