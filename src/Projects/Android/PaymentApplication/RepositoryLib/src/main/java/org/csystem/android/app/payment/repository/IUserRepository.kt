package org.csystem.android.app.payment.repository

import com.karandev.util.data.repository.ICrudRepository
import org.csystem.android.app.payment.repository.entity.User

interface IUserRepository : ICrudRepository<User, String> {
    fun existsByUserNameAndPassword(userName: String, password: String) : Boolean
}