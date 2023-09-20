package org.csystem.android.app.payment.repository

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import org.csystem.android.app.payment.repository.entity.User
import java.util.Optional
import javax.inject.Inject

class UserRepository @Inject constructor(@ApplicationContext context: Context) : IUserRepository {

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

    override fun <S : User?> save(entity: S): S
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

    override fun existsById(id: String?): Boolean
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