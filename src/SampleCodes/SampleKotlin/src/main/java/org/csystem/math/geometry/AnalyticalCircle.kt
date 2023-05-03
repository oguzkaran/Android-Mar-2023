/*----------------------------------------------------------------------
	FILE        : AnalyticalCircle.kt
	AUTHOR      : Android-May-2022 Group
	LAST UPDATE : 03.05.2023

	AnalyticalCircle class that represents a circle in cartesian plane

	Copyleft (c) 1993 by C and System Programmers Association
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.math.geometry

import kotlin.math.abs

open class AnalyticalCircle(radius: Double = 0.0, x: Double = 0.0, y: Double = 0.0) : Circle (radius) {
    private val mCenter = MutablePoint(x, y)
    constructor(radius: Double = 0.0, center: MutablePoint) : this(radius, center.x, center.y)
    constructor(radius: Double = 0.0, center: Point) : this(radius, center.x, center.y)

    var x: Double
        get() = mCenter.x
        set(value)
        {
            mCenter.x = value
        }

    var y: Double
        get() = mCenter.y
        set(value)
        {
            mCenter.y = value
        }

    fun centerDistance(other: AnalyticalCircle) = mCenter.distance(other.mCenter)
    fun isTangent(other: AnalyticalCircle) = abs(centerDistance(other) - radius - other.radius) < 0.00001
    //...
}