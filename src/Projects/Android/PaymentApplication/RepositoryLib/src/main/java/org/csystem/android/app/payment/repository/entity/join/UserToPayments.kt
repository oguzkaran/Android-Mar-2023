package org.csystem.android.app.payment.repository.entity.join

import androidx.room.Embedded
import androidx.room.Relation
import org.csystem.android.app.payment.repository.entity.Payment
import org.csystem.android.app.payment.repository.entity.User

data class UserToPayments(@Embedded val user: User,
                          @Relation(parentColumn = "username", entityColumn = "username")
                          var payments: List<Payment>)
