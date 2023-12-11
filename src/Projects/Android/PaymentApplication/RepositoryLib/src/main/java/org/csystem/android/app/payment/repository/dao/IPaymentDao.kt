package org.csystem.android.app.payment.repository.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import org.csystem.android.app.payment.repository.entity.Payment
import org.csystem.android.app.payment.repository.entity.join.UserToPayments

@Dao
interface IPaymentDao {
    @Query("SELECT * FROM users WHERE username = :username")
    @Transaction
    fun findByUserName(username: String) : List<UserToPayments>
    @Insert
    fun save(payment: Payment)
}