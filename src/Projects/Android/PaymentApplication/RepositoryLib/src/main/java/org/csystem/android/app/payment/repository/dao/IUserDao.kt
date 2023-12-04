package org.csystem.android.app.payment.repository.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import org.csystem.android.app.payment.repository.entity.User
import org.csystem.android.app.payment.repository.entity.join.UserPaymentInfo

@Dao
interface IUserDao {
    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    fun findByUserNameAndPassword(username: String, password: String) : User?

    @Query("""SELECT u.username, p.description, p.quantity, p.unit_price
        FROM users u INNER JOIN payments p on u.username = p.username WHERE u.username = :username""")
    fun findPaymentInfo(username: String) : List<UserPaymentInfo>

    fun existsByUserNameAndPassword(username: String, password: String) = findByUserNameAndPassword(username, password) != null

    @Insert
    fun save(user: User)

    @Query("SELECT EXISTS(SELECT * FROM users WHERE username = :username)")
    fun existsById(username: String):  Boolean
}