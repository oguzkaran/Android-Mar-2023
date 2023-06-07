/*----------------------------------------------------------------------------------------------------------------------
    apply eklenti fonksiyonu: apply eklenti fonksiyonunun callback'ine this geçirilir
    "apply the following assignments or calls to the object"
    apply fonksiyonu çağrıldığı referansa geri döner
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import org.csystem.util.console.kotlin.readInt

fun main()
{
    var a = readInt("Bir sayı giriniz:").apply {
        println("a = $this")
        println("$this * $this")
    }

    ++a

    println(a)

}
