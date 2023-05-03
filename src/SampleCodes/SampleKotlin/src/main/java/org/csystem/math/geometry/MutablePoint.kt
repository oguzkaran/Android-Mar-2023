/*----------------------------------------------------------------------
	FILE        : MutablePoint.kt
	AUTHOR      : Android-May-2022 Group
	LAST UPDATE : 03.05.2023

	Mutable Point class that represents a point in cartesian plane

	Copyleft (c) 1993 by C and System Programmers Association
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.math.geometry

import kotlin.math.sqrt

class MutablePoint(var x: Double = 0.0, var y: Double = 0.0) {
    constructor(x: Int, y: Int) : this(x.toDouble(), y.toDouble()) //optional
    fun distance(a: Double = 0.0, b: Double = 0.0) = sqrt((x - a) * (x - a) + (y - b) * (y - b))
    fun distance(other: MutablePoint) = distance(other.x, other.y)

    fun offset(dx: Double, dy: Double = dx)
    {
        x += dx
        y += dy
    }
}