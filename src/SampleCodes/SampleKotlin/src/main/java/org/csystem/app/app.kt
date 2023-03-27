/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örneği inceleyiniz. ** ile belirtilen çağrıda "tam uyum (best match)" dolayısıyla parametresiz
    foo çağrılır. Aşağıdaki Int parametreli fonksiyon için parametresiz foo varken default argüman anlamlı mıdır? Şüphesiz
    bu soru örnek özelinde düşünülmeldir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

fun main()
{
    foo() //**
    foo(34)
    foo(0)
}

fun foo(a: Int = 0) = println("a = $a")
fun foo() = println("foo")
