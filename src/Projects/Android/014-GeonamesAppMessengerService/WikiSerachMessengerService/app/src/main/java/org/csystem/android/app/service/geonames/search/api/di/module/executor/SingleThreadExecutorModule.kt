package org.csystem.android.app.service.geonames.search.api.di.module.executor

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SingleThreadExecutorModule {
    @Provides
    @Singleton
    fun create() : ExecutorService = Executors.newSingleThreadExecutor()
}