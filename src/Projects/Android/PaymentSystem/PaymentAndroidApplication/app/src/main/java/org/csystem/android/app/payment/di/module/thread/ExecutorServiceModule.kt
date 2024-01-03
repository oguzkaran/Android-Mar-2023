package org.csystem.android.app.payment.di.module.thread

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import javax.inject.Singleton

private const val CORE_POOL_SIZE = 2
@Module
@InstallIn(SingletonComponent::class)
object ExecutorServiceModule {
    @Provides
    @Singleton
    fun createExecutorService() : ScheduledExecutorService = Executors.newScheduledThreadPool(CORE_POOL_SIZE)
}