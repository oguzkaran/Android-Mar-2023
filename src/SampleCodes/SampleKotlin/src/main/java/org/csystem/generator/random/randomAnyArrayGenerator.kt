package org.csystem.generator.random

import org.csystem.math.geometry.Circle
import org.csystem.math.geometry.Point
import kotlin.random.Random

private fun createRandomString(count: Int, random: Random) : String
{
    val sb = StringBuilder()

    for (i in 1..count)
        sb.append((if (random.nextBoolean()) 'A' else 'a') + random.nextInt(26))

    return sb.toString()
}

//String, Int, Point, Boolean, Circle
private fun createRandomAny(random: Random) : Any
{
    return when (random.nextInt(5)) {
        0 -> createRandomString(random.nextInt(5, 15), random)
        1 -> random.nextInt(-128, 128)
        2 -> Point(random.nextDouble(-100.0, 100.0), random.nextDouble(-100.0, 100.0))
        3 -> random.nextBoolean()
        else -> Circle(random.nextDouble(-3.0, 3.0))
    }
}

fun createRandomAnyArray(count: Int, random: Random = Random) : Array<Any>
{
    val result = Array<Any>(count){}

    for (i in result.indices)
        result[i] = createRandomAny(random)

    return result
}