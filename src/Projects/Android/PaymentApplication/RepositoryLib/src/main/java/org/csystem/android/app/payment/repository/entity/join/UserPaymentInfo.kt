package org.csystem.android.app.payment.repository.entity.join

import org.csystem.android.app.payment.repository.entity.User

data class UserPaymentInfo(var username: User, var description: String,
                           var quantity: Double, var unitPrice: Double)
