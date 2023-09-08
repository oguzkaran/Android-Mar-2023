package org.csystem.android.app.hilt.calculator

import javax.inject.Inject

class IntAddOperation @Inject constructor() : IBinaryOperator<Int> {
    override fun applyAsInt(a: Int, b: Int): Int
    {
        return a + b
    }

    override fun isValid(op: Char) = op == '+'
}