/*----------------------------------------------------------------------
	FILE        : Complex.kt
	AUTHOR      : Android-May-2022 Group
	LAST UPDATE : 15.05.2023

	Immutable Complex class that represents the complex number

	Copyleft (c) 1993 by C and System Programmers Association
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.math

import kotlin.math.sqrt

private const val DELTA = 0.00001

data class Complex(val real: Double = 0.0, val imag: Double = 0.0) {
    val norm: Double
        get() = sqrt(real * real + imag * imag)

    val length: Double
        get() = norm

    val conjugate: Complex
        get() = Complex(real, -imag)

    operator fun component3() = norm
    operator fun component4() = conjugate

    //Operator functions

    override fun toString() = "(%.2f, %.2f)".format(real, imag)
}