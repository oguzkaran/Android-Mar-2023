/*----------------------------------------------------------------------
	FILE        : Quadruple.kt
	AUTHOR      : Android-May-2022 Group
	LAST UPDATE : 31.05.2023

	Quadruple class

	Copyleft (c) 1993 by C and System Programmers Association (org.csystem.app)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.tuple

import java.io.Serializable

data class Quadruple<out T1, out T2, out T3, out T4>(val first: T1, val second: T2, val third: T3, val forth: T4) : Serializable {
    override fun toString() = "($first, $second, $third, $forth)"
}
