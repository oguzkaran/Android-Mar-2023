/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte ** ile belirtilen ifade için yeni bir nesne yaratılmış olur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

fun main()
{
    val A = A(10)
    val x = A(20) //**

    println(x)
}


class A(x: Int) {
    init {
        println("A.ctor, int")
    }
}
