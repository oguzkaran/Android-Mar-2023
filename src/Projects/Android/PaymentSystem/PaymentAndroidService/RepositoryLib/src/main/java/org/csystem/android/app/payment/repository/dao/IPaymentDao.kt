package org.csystem.android.app.payment.repository.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import org.csystem.android.app.payment.repository.entity.Payment
import org.csystem.android.app.payment.repository.entity.join.UserPaymentInfo

@Dao
interface IPaymentDao {
    @Query("""SELECT
        u.username,
        p.description,
        p.quantity,
        p.unit_price
        FROM users u INNER JOIN payments p on u.username = p.username 
        WHERE u.username = :username
    """)
    fun findByUserName(username: String) : List<UserPaymentInfo>

    @Insert
    fun save(payment: Payment)
}