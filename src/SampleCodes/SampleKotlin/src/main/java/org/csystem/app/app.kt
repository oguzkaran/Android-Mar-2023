/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte default ctor primary ctor yapılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

fun main()
{
    var s1 = Sample(10)
    println("---------------------------")
    var s2 = Sample(4.5)
    println("---------------------------")
    var s3 = Sample()
    println("---------------------------")

    //...
}

class Sample() {
    init {
        println("primary constructor")
    }

    constructor(b: Double) : this()
    {
        println("constructor(Double)")
    }

    constructor(b: Int) : this(b.toDouble())
    {
        println("constructor(Int)")
    }
}
