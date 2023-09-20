package org.csystem.android.app.payment.repository

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import org.csystem.android.app.payment.repository.entity.Payment
import java.util.Optional
import javax.inject.Inject

class PaymentRepository @Inject constructor(@ApplicationContext context: Context) : IPaymentRepository {

    /////////////////////////////////////////////////////////
    override fun count(): Long
    {
        TODO("Not yet implemented")
    }

    override fun delete(entity: Payment?)
    {
        TODO("Not yet implemented")
    }

    override fun deleteAll()
    {
        TODO("Not yet implemented")
    }

    override fun deleteAll(entities: MutableIterable<Payment>?)
    {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableIterable<Payment>
    {
        TODO("Not yet implemented")
    }

    override fun <S : Payment?> save(entity: S): S
    {
        TODO("Not yet implemented")
    }

    override fun <S : Payment?> saveAll(entities: MutableIterable<S>?): MutableIterable<S>
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

    override fun findAllById(id: MutableIterable<Long>?): MutableIterable<Payment>
    {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long?): Optional<Payment>
    {
        TODO("Not yet implemented")
    }
}