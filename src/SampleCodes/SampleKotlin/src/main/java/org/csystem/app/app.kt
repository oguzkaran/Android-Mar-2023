/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Bir karmaşık sayıyı temsil eden Complex isimli immutable sınıfı yazınız.
    Sınıf karmaşık sayının 0 + 0i sayısına uzaklığı olan Norm bilgisini de verecektir
    |a + bi| = sqrt(a * a + b * b)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import org.csystem.math.Complex

fun main()
{
    val z = Complex(3.4, 5.6)
    val zc = z.conjugate;

    println("|${z.real} + i.${z.imag}| = ${z.norm}")
    println("|${zc.real} + i.${zc.imag}| = ${zc.norm}")
}
