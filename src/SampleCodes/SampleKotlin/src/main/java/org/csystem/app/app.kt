/*----------------------------------------------------------------------------------------------------------------------
    Programcı data sınıfları için primary ctor'da bildirmediği property elemanları için de componentN fonksiyonlarını
    yazabilir. Bu fonksiyonlar aslında operatör fonksiyonu olduğundan operator anahtar sözcüğü ile bildirilmelidir. Aksi
    durumda fonksiyon operatör fonksiyonu olmaz. Bu durumda parçalama yapılamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import org.csystem.math.Complex
import org.csystem.util.console.kotlin.readInt
import kotlin.random.Random

fun main()
{
    val n = readInt("Input a number:")

    for ((re, im, _, conj) in createRandomComplexNumbers(n, -10.0, 10.0))
        println("$re + $im * i -> $conj")
}

fun createRandomComplexNumbers(count: Int, min: Double, bound: Double, random: Random = Random) = Array<Complex>(count) { createRandomComplex(min, bound, random) }
fun createRandomComplex(min: Double, bound: Double, random: Random = Random) = Complex(random.nextDouble(min, bound), random.nextDouble(min, bound))