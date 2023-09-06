package org.csystem.android.app.hilt.calculator

import javax.inject.Inject

class IntMultiplyOperation @Inject constructor() : IIBinaryOperator<Int> {

    override fun applyAsInt(a: Int, b: Int): Int
    {
        return a * b
    }

    override fun isValid(op: Char) = op == '*'
}