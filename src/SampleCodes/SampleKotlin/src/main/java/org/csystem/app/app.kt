/*----------------------------------------------------------------------------------------------------------------------
    is operatörü
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import org.csystem.util.console.kotlin.readInt
import kotlin.random.Random

fun main()
{
    val count = readInt("Bir sayı giriniz:")

    for (i in 1..count) {
        val x: A = createRandomA()

        println("---------------------------------------")
        println(x.javaClass.name)

        if (x is C) {
            x.c = 10
            println("x.c = ${x.c}")
        }
        else
            println("Haksız dönüşüm")

        println("---------------------------------------")
    }

    println("Tekrar yapıyor musunuz?")
}

fun createRandomA(random: Random = Random) : A
{
    return when (random.nextInt(5)) {
        0 -> B()
        1 -> C()
        2 -> D()
        3 -> E()
        else -> A()
    }
}

open class A {
    //...
}

open class B : A() {
    //...
}

open class C(var c: Int  = 10) : B() {
    //...
}

class D : A() {
    //...
}

class E : C() {
    //..
}
