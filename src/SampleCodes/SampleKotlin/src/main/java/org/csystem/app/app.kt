/*----------------------------------------------------------------------------------------------------------------------
    Tek parametreli Lambda fonksiyonlarda it built-in olarak parametre ismi olarak kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

fun main()
{
    foo{it - 3}
}

fun foo(f: (Int) -> Int)
{
    println(f(0))
}