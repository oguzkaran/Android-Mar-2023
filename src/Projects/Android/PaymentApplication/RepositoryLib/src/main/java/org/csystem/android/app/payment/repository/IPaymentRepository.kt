package org.csystem.android.app.payment.repository

import com.karandev.util.data.repository.ICrudRepository
import org.csystem.android.app.payment.repository.entity.Payment

interface IPaymentRepository : ICrudRepository<Payment, Long> {
    fun findByUserName(userName: String) : List<Payment>
}