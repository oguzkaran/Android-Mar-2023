package org.csystem.android.app.payment.repository.di.module.database.dao

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.csystem.android.app.payment.repository.dao.IPaymentDao
import org.csystem.android.app.payment.repository.database.PaymentApplicationDatabase
import org.csystem.android.app.payment.repository.di.module.database.PaymentApplicationDatabaseInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PaymentDaoModule {
    @Provides
    @Singleton
    fun createPaymentDao(@PaymentApplicationDatabaseInterceptor paymentApplicationDatabase: PaymentApplicationDatabase) : IPaymentDao
    {
        return paymentApplicationDatabase.createPaymentDao()
    }
}