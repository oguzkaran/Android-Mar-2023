/*----------------------------------------------------------------------------------------------------------------------
    Taban sınıf türünden bir referans türemiş sınıf türünden bir referansa as operatörü ile atanabilir (downcasting).
    Bu işlem derleme zamanından geçmek içindir. Bu durumda çalışma zamanında kaynak referansın dinamik türünün as operatörüne
    verilen türü kapsayıp kapsamadığına bakılır. Kapsıyorsa haklı dönüşümdür, akış devam eder. Kapsamıyorsa haksız
    dönüşümdür, exception oluşur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import org.csystem.util.console.kotlin.readInt
import kotlin.random.Random

fun main()
{
    val count = readInt("Bir sayı giriniz:")

    for (i in 1..count) {
        val x: A = createRandomA()

        println(x.javaClass.name)

        val y: C = x as C

        y.c = 10

        println("y.c = ${y.c}")
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