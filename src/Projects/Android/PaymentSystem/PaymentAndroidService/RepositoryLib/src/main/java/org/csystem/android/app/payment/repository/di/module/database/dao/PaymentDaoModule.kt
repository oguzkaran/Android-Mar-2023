package org.csystem.android.app.payment.repository.di.module.database.dao

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.csystem.android.app.payment.repository.dao.IPaymentDao
import org.csystem.android.app.payment.repository.database.PaymentApplicationDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PaymentDaoModule {
    @Provides
    @Singleton
    fun createPaymentDao( paymentApplicationDatabase: PaymentApplicationDatabase) : IPaymentDao
    {
        return paymentApplicationDatabase.createPaymentDao()
    }
}