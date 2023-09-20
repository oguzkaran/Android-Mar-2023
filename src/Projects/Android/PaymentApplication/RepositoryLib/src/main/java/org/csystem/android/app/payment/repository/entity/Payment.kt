package org.csystem.android.app.payment.repository.entity

data class Payment(var id: Long, var userName: String,
                   var unitPrice: Double, var quantity: Int, var description: String)