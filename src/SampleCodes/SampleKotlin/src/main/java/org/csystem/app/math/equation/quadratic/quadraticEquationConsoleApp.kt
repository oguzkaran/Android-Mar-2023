package org.csystem.app.math.equation.quadratic

import org.csystem.math.equation.quadratic.solveQuadraticEquation
import org.csystem.util.console.kotlin.readDouble

private fun runQuadraticEquationConsoleApp()
{
    while (true) {
        val a = readDouble("Input a:")

        if (a == 0.0)
            break

        val b = readDouble("Input b:")
        val c = readDouble("Input c:")

        val (x1, x2, exists) = solveQuadraticEquation(a, b, c)

        if (exists)
            println("x1 = $x1, x2 = $x2")
        else
            println("No real root")
    }
}


fun main() = runQuadraticEquationConsoleApp()

