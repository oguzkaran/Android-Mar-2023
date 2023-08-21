package org.csystem.android.app.multipleactivity.viewmodel

import java.io.Serializable

data class PaymentInfo(var name: String = "", var unitPrice: Double = 0.0, var quantity: Int = 0) : Serializable{
    val total: Double
        get() = unitPrice * quantity

    override fun toString() = "$name, $unitPrice * $quantity = ${unitPrice * quantity}"
}