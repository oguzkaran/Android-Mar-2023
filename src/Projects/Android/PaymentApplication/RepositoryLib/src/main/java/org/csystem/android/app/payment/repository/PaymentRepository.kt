package org.csystem.android.app.payment.repository

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import org.csystem.android.app.payment.repository.entity.Payment
import org.csystem.android.app.payment.repository.global.PAYMENT_FILE
import java.io.EOFException
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.util.Optional
import javax.inject.Inject

class PaymentRepository @Inject constructor(@ApplicationContext context: Context) : IPaymentRepository {
    private val mContext = context

    private fun findByUserNameCallback(userName: String, fis: FileInputStream): List<Payment>
    {
        val payments = ArrayList<Payment>();
        try {
            while (true) {
                val payment = ObjectInputStream(fis).readObject() as Payment

                if (payment.userName == userName)
                    payments.add(payment)
            }
        }
        catch (ignore: EOFException) {

        }

        return payments
    }
    private fun  <S : Payment?> saveCallBack(payment: S, fos: FileOutputStream) : S
    {
        ObjectOutputStream(fos).writeObject(payment)

        return payment
    }

    override fun <S : Payment?> save(payment: S) : S
    {
        return mContext.openFileOutput(PAYMENT_FILE, Context.MODE_APPEND).use{saveCallBack(payment, it)}
    }

    override fun findByUserName(userName: String): List<Payment>
    {
        return mContext.openFileInput(PAYMENT_FILE).use { findByUserNameCallback(userName, it) }
    }

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