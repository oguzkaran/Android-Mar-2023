package org.csystem.android.app.payment.repository.entity.join

import androidx.room.ColumnInfo
import org.csystem.android.app.payment.repository.entity.User

data class UserPaymentInfo(@ColumnInfo(name = "username") var username: String,
                           @ColumnInfo(name = "description") var description: String,
                           @ColumnInfo(name = "quantity")var quantity: Double,
                           @ColumnInfo(name = "unit_price") var unitPrice: Double)
