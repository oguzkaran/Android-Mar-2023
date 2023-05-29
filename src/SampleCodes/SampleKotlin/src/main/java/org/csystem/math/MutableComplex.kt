/*----------------------------------------------------------------------
	FILE        : MutableComplex.kt
	AUTHOR      : Android-May-2022 Group
	LAST UPDATE : 29.05.2023

	MutableComplexclass that represents the complex number

	Copyleft (c) 1993 by C and System Programmers Association
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.math

import java.lang.IndexOutOfBoundsException
import kotlin.math.sqrt

private fun plus(a1: Double, b1: Double, a2: Double, b2: Double) = MutableComplex(a1 + a2, b1 + b2)
private fun minus(a1: Double, b1: Double, a2: Double, b2: Double) = plus(a1, b1, -a2, -b2)
private fun times(a1: Double, b1: Double, a2: Double, b2: Double) : MutableComplex
{
    TODO()
}

private fun div(a1: Double, b1: Double, a2: Double, b2: Double) : MutableComplex
{
    TODO()
}

operator fun Double.plus(z: MutableComplex) = plus(this, 0.0, z.real, z.imag)
operator fun Double.minus(z: MutableComplex) = minus(this, 0.0, z.real, z.imag)
operator fun Double.times(z: MutableComplex) = times(this, 0.0, z.real, z.imag)
operator fun Double.div(z: MutableComplex) = div(this, 0.0, z.real, z.imag)

data class MutableComplex(var real: Double = 0.0, var imag: Double = 0.0) {
    val norm: Double
        get() = sqrt(real * real + imag * imag)

    val length: Double
        get() = norm

    val conjugate: MutableComplex
        get() = MutableComplex(real, -imag)

    operator fun component3() = norm
    operator fun component4() = conjugate

    operator fun plus(other: MutableComplex) = plus(real, imag, other.real, other.imag)
    operator fun plus(value: Double) = plus(real, imag, value, 0.0)

    operator fun minus(other: MutableComplex) = minus(real, imag, other.real, other.imag)
    operator fun minus(value: Double) = minus(real, imag, value, 0.0)

    operator fun times(other: MutableComplex) = times(real, imag, other.real, other.imag)
    operator fun times(value: Double) = times(real, imag, value, 0.0)

    operator fun div(other: MutableComplex) = div(real, imag, other.real, other.imag)
    operator fun div(value: Double) = div(real, imag, value, 0.0)

    operator fun unaryMinus() = MutableComplex(-real, -imag)
    operator fun unaryPlus() = copy()
    operator fun inc() = MutableComplex(real + 1, imag)
    operator fun dec() = MutableComplex(real - 1, imag)

    operator fun invoke(real: Double, imag: Double = 0.0) : MutableComplex
    {
        val old = MutableComplex(this.real, this.imag)
        this.real = real
        this.imag = imag

        return old
    }

    operator fun get(index: Int) : Double
    {
        if (index < 0 || index > 1)
            throw IndexOutOfBoundsException("index must be zero or one")

        return if (index == 0) real else imag
    }

    operator fun set(index: Int, value: Double)
    {
        if (index < 0 || index > 1)
            throw IndexOutOfBoundsException("index must be zero or one")
        if (index == 0)
            real = value
        else
            imag = value
    }

    override fun toString() = "(%.2f, %.2f)".format(real, imag)
}