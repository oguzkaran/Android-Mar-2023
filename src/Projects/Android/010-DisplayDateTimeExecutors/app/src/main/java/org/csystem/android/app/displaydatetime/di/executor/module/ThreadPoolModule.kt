package org.csystem.android.app.displaydatetime.di.executor.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ThreadPoolModule {
    @Provides
    @Singleton
    fun createThreadPool() : ScheduledExecutorService = Executors.newScheduledThreadPool(3)
}