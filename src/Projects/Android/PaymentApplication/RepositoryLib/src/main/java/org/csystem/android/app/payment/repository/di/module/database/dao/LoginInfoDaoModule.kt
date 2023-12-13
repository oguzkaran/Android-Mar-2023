package org.csystem.android.app.payment.repository.di.module.database.dao

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.csystem.android.app.payment.repository.dao.ILoginInfoDao
import org.csystem.android.app.payment.repository.database.PaymentApplicationDatabase
import org.csystem.android.app.payment.repository.di.module.database.PaymentApplicationDatabaseInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LoginInfoDaoModule {
    @Provides
    @Singleton
    fun createLoginInfoDao(@PaymentApplicationDatabaseInterceptor paymentApplicationDatabase: PaymentApplicationDatabase) : ILoginInfoDao
    {
        return paymentApplicationDatabase.createLoginInfoDao()
    }
}