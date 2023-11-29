package org.csystem.android.app.payment.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.karandev.util.data.repository.ICrudRepository
import org.csystem.android.app.payment.repository.entity.User

@Dao
interface IUserDao {
    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    fun findByUserNameAndPassword(username: String, password: String) : User?
    fun existsByUserNameAndPassword(username: String, password: String) = findByUserNameAndPassword(username, password) != null

    @Insert
    fun save(user: User)

    fun existsById(username: String):  Boolean
}