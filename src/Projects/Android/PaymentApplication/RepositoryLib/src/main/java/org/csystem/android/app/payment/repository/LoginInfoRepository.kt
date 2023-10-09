package org.csystem.android.app.payment.repository

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import org.csystem.android.app.payment.repository.entity.LoginInfo
import org.csystem.android.app.payment.repository.global.LOGIN_INFO_FILE
import java.io.EOFException
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.util.Optional
import javax.inject.Inject

class LoginInfoRepository @Inject constructor(@ApplicationContext var context: Context) : ILoginInfoRepository {
    private fun findByUserNameCallback(fis: FileInputStream, username: String): List<LoginInfo>
    {
        val list = ArrayList<LoginInfo>()

        try {
            while (true) {
                val ois = ObjectInputStream(fis)

                val loginInfo = ois.readObject() as LoginInfo

                if (loginInfo.username == username)
                    list.add(loginInfo)
            }
        }
        catch (ignore: EOFException) {

        }

        return list
    }

    private fun findSuccessByUserNameCallback(fis: FileInputStream, username: String): List<LoginInfo>
    {
        val list = ArrayList<LoginInfo>()

        try {
            while (true) {
                val ois = ObjectInputStream(fis)

                val loginInfo = ois.readObject() as LoginInfo

                if (loginInfo.username == username && loginInfo.success)
                    list.add(loginInfo)
            }
        }
        catch (ignore: EOFException) {

        }

        return list
    }

    private fun findFailsByUserNameCallback(fis: FileInputStream, username: String): List<LoginInfo>
    {
        val list = ArrayList<LoginInfo>()

        try {
            while (true) {
                val ois = ObjectInputStream(fis)

                val loginInfo = ois.readObject() as LoginInfo

                if (loginInfo.username == username && !loginInfo.success)
                    list.add(loginInfo)
            }
        }
        catch (ignore: EOFException) {

        }

        return list
    }

    private fun <S : LoginInfo?> saveCallback(fos: FileOutputStream, user: S): S
    {
        ObjectOutputStream(fos).writeObject(user)

        return user
    }

    override fun <S : LoginInfo?> save(loginInfo: S): S
    {
        return context.openFileOutput(LOGIN_INFO_FILE, Context.MODE_APPEND).use{saveCallback(it, loginInfo)}
    }

    override fun findByUserName(username: String): List<LoginInfo>
    {
        return context.openFileInput(LOGIN_INFO_FILE).use { findByUserNameCallback(it, username) }
    }

    override fun findSuccessByUserName(username: String): List<LoginInfo>
    {
        return context.openFileInput(LOGIN_INFO_FILE).use { findSuccessByUserNameCallback(it, username) }
    }

    override fun findFailsByUserName(username: String): List<LoginInfo>
    {
        return context.openFileInput(LOGIN_INFO_FILE).use { findFailsByUserNameCallback(it, username) }
    }


    ////////////////////////////////////////////////////////

    override fun findLastSuccessByUserName(username: String): List<LoginInfo>
    {
        TODO("Not yet implemented")
    }

    override fun findLastFailByUserName(username: String): List<LoginInfo>
    {
        TODO("Not yet implemented")
    }

    override fun count(): Long
    {
        TODO("Not yet implemented")
    }

    override fun delete(entity: LoginInfo?)
    {
        TODO("Not yet implemented")
    }

    override fun deleteAll()
    {
        TODO("Not yet implemented")
    }

    override fun deleteAll(entities: MutableIterable<LoginInfo>?)
    {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableIterable<LoginInfo>
    {
        TODO("Not yet implemented")
    }



    override fun <S : LoginInfo?> saveAll(entities: MutableIterable<S>?): MutableIterable<S>
    {
        TODO("Not yet implemented")
    }

    override fun deleteAllById(ids: MutableIterable<Long>?)
    {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long?)
    {
        TODO("Not yet implemented")
    }

    override fun existsById(id: Long?): Boolean
    {
        TODO("Not yet implemented")
    }

    override fun findAllById(id: MutableIterable<Long>?): MutableIterable<LoginInfo>
    {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long?): Optional<LoginInfo>
    {
        TODO("Not yet implemented")
    }
}