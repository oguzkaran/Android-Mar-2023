/*----------------------------------------------------------------------------------------------------------------------
    Point sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

fun main()
{
    val p1 = Point(234.0, -456.7)
    val p2 = Point(230.0, -453.7)

    println("Distance: ${p1.distance(p2)}");
    println("Distance: ${p1.distance()}");

}

class Point(var x: Double = 0.0, var y: Double = 0.0) {
    constructor(x: Int, y: Int) : this(x.toDouble(), y.toDouble()) //optional
    fun distance(a: Double = 0.0, b: Double = 0.0) = kotlin.math.sqrt((x - a) * (x - a) + (y - b) * (y - b))
    fun distance(other: Point) = distance(other.x, other.y)
}



