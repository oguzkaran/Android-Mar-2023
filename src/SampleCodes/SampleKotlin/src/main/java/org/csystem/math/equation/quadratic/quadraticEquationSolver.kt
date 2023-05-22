package org.csystem.math.equation.quadratic

import kotlin.math.sqrt

private fun calculateDelta(a: Double, b: Double, c: Double) = b * b - 4 * a * c

fun solveQuadraticEquation(a: Double, b: Double, c: Double) : QuadraticEquationResultInfo
{
    val delta = calculateDelta(a, b, c)

    return when {
        delta >= 0 -> {
            val sqrtDelta = sqrt(delta)
            QuadraticEquationResultInfo((-b + sqrtDelta) / (2 * a), (-b - sqrtDelta) / (2 * a), true)
        }
        else -> QuadraticEquationResultInfo(Double.NaN, Double.NaN, false)
    }
}
