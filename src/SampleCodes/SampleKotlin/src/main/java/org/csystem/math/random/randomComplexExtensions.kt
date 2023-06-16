package org.csystem.math.random

import org.csystem.math.Complex
import org.csystem.math.MutableComplex
import kotlin.random.Random

fun Random.nextComplex(min: Double, bound: Double) = Complex(this.nextDouble(min, bound), this.nextDouble(min, bound))
fun Random.nextComplex(min: Int, bound: Int) = Complex(this.nextInt(min, bound).toDouble(), this.nextInt(min, bound).toDouble())

fun Random.nextMutableComplex(min: Double, bound: Double) = MutableComplex(this.nextDouble(min, bound), this.nextDouble(min, bound))
fun Random.nextMutableComplex(min: Int, bound: Int) = MutableComplex(this.nextInt(min, bound).toDouble(), this.nextInt(min, bound).toDouble())
