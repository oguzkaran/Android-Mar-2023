/*----------------------------------------------------------------------
	FILE        : Value.kt
	AUTHOR      : Android-Mar-2023 Group
	LAST UPDATE : 31.05.2023

	Quadruple class

	Copyleft (c) 1993 by C and System Programmers Association (org.csystem.app)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.tuple

import java.io.Serializable

data class Value<out T>(val value: T) : Serializable {
    fun toList() : List<T> = listOf(value)
}
