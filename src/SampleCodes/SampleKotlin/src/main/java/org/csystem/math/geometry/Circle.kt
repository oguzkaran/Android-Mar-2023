/*----------------------------------------------------------------------
	FILE        : Circle.kt
	AUTHOR      : Android-May-2022 Group
	LAST UPDATE : 15.05.2023

	Circle class that represents the circle in geometry

	Copyleft (c) 1993 by C and System Programmers Association
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.math.geometry

import kotlin.math.abs

private const val DELTA = 0.00001

open class Circle(radius: Double = 0.0) {
    var radius: Double = abs(radius)
        set(value) {
            field = abs(value)
        }

    val area : Double
        get() = Math.PI * radius * radius

    val circumference : Double
        get() = 2 * Math.PI * radius

    override fun toString() = "Radius = %.2f, Area =  %.2f, Circumference = %.2f".format(radius, area, circumference)

    override operator fun equals(other: Any?) = other is Circle && abs(radius - other.radius) < DELTA;
}
