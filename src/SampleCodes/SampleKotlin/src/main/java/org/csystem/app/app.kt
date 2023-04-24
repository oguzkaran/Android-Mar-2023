/*----------------------------------------------------------------------------------------------------------------------
   Yıldızsız import bildiriminde (import single type declaration) ilgili isme takma isim (alias) verilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import org.csystem.util.console.kotlin.readInt as rInt

fun main()
{
    val a = rInt("Bir sayı giriniz:")

    println("a = $a")
}