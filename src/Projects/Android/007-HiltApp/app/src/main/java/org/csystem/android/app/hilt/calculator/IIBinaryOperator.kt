package org.csystem.android.app.hilt.calculator

interface IIBinaryOperator<T> {
    fun applyAsInt(a: T, b: T) : T
    fun isValid(op: Char) : Boolean
}