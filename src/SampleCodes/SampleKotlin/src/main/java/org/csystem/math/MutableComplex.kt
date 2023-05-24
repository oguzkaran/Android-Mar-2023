/*----------------------------------------------------------------------
	FILE        : MutableComplex.kt
	AUTHOR      : Android-May-2022 Group
	LAST UPDATE : 24.05.2023

	MutableComplexclass that represents the complex number

	Copyleft (c) 1993 by C and System Programmers Association
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.math

import kotlin.math.sqrt

data class MutableComplex(var real: Double = 0.0, var imag: Double = 0.0) {
    val norm: Double
        get() = sqrt(real * real + imag * imag)

    val length: Double
        get() = norm

    val conjugate: MutableComplex
        get() = MutableComplex(real, -imag)

    operator fun component3() = norm
    operator fun component4() = conjugate

    operator fun plus(other: MutableComplex) = MutableComplex(real + other.real, imag + other.imag)
    operator fun plus(value: Double) = MutableComplex(real + value, imag)
    override fun toString() = "(%.2f, %.2f)".format(real, imag)
}