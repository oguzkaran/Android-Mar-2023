/*----------------------------------------------------------------------
	FILE        : Complex.kt
	AUTHOR      : Android-May-2022 Group
	LAST UPDATE : 19.04.2023

	Immutable Complex class that represents the complex number

	Copyleft (c) 1993 by C and System Programmers Association
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.math

class Complex {
    //...
    val norm: Double
        get() = TODO()

    val length: Double
        get() = norm

    val conjugate: Complex = TODO("a + ib -> a - ib")
}