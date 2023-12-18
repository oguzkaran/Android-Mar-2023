package org.csystem.android.app.payment.repository.di.module.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.csystem.android.app.payment.repository.database.PaymentApplicationDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PaymentApplicationDatabaseModule {
    @Singleton
    @Provides
    fun createPaymentApplicationDatabase(@ApplicationContext context: Context) : PaymentApplicationDatabase
    {
        return Room.databaseBuilder(context, PaymentApplicationDatabase::class.java, "paymentdb.sqlite3").build()
    }
}