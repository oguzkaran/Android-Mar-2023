package org.csystem.android.app.payment.repository.entity

import java.io.Serializable

data class Payment(var id: Long, var userName: String,
                   var unitPrice: Double, var quantity: Int, var description: String) : Serializable