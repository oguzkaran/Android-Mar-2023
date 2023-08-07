package org.csystem.android.app.multipleactivity.viewmodel

data class PaymentInfo(var name: String = "", var unitPrice: Double = 0.0, var quantity: Int = 0) {
    override fun toString() = "$name, $unitPrice * $quantity = ${unitPrice * quantity}"
}