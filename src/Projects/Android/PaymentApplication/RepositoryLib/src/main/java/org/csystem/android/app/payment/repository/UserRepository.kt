package org.csystem.android.app.payment.repository

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import org.csystem.android.app.payment.repository.entity.User
import org.csystem.android.app.payment.repository.global.USER_FILE
import java.io.EOFException
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.util.Optional
import javax.inject.Inject

class UserRepository @Inject constructor(@ApplicationContext context: Context) : IUserRepository {
    private val mContext : Context = context

    private fun <S: User?> saveCallback(fos: FileOutputStream, user: S): S
    {
        ObjectOutputStream(fos).writeObject(user)

        return user
    }

    private fun findByUserNameAndPasswordCallback(fis: FileInputStream, userName: String, password: String)  : User?
    {
        var user : User? = null

        try {
            while (true) {
                user = ObjectInputStream(fis).readObject() as? User

                if (user?.username == userName && user.password == password)
                    break
            }
        }
        catch (ignore: EOFException) {
            user = null
        }

        return user
    }

    private fun existsByIdCallback(fis: FileInputStream, userName: String)  : Boolean
    {
        var user : User? = null

        try {
            while (true) {
                user = ObjectInputStream(fis).readObject() as? User

                if (user?.username == userName)
                    break
            }
        }
        catch (ignore: EOFException) {
            user = null
        }

        return user != null
    }

    override fun <S : User?> save(user: S): S
    {
        return mContext.openFileOutput(USER_FILE, Context.MODE_APPEND).use {saveCallback(it, user)}
    }

    override fun findByUserNameAndPassword(userName: String, password: String): User?
    {
        return mContext.openFileInput(USER_FILE).use { findByUserNameAndPasswordCallback(it, userName, password) }
    }

    override fun existsById(userName: String?): Boolean
    {
        return mContext.openFileInput(USER_FILE).use {existsByIdCallback(it, userName!!)}
    }

    /////////////////////////////////////////////////////////////////////////////////////////

    override fun existsByUserNameAndPassword(userName: String, password: String): Boolean
    {
        TODO("Not yet implemented")
    }

    override fun count(): Long
    {
        TODO("Not yet implemented")
    }

    override fun delete(entity: User?)
    {
        TODO("Not yet implemented")
    }

    override fun deleteAll()
    {
        TODO("Not yet implemented")
    }

    override fun deleteAll(entities: MutableIterable<User>?)
    {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableIterable<User>
    {
        TODO("Not yet implemented")
    }



    override fun <S : User?> saveAll(entities: MutableIterable<S>?): MutableIterable<S>
    {
        TODO("Not yet implemented")
    }

    override fun deleteAllById(ids: MutableIterable<String>?)
    {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String?)
    {
        TODO("Not yet implemented")
    }



    override fun findAllById(id: MutableIterable<String>?): MutableIterable<User>
    {
        TODO("Not yet implemented")
    }

    override fun findById(id: String?): Optional<User>
    {
        TODO("Not yet implemented")
    }
}