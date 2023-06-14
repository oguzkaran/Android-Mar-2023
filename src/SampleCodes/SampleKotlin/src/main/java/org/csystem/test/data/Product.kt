package org.csystem.test.data

import java.math.BigDecimal

data class Product(var id: Int = 0,
                   var name: String = "",
                   var stock: Int = 0,
                   var cost: BigDecimal = BigDecimal.ZERO,
                   var price: BigDecimal = BigDecimal.ZERO) {

    override fun hashCode(): Int = id

    override fun equals(other: Any?) = other is Product && other.id == id
}