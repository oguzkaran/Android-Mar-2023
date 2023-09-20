package org.csystem.android.util.datetime.di.module.formatter

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.csystem.android.util.datetime.di.module.formatter.annotation.LocalTimeFormatterInterceptor
import java.time.format.DateTimeFormatter
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalTimeFormatterModule {
    @Provides
    @Singleton
    @LocalTimeFormatterInterceptor
    fun provideFormatter() : DateTimeFormatter = DateTimeFormatter.ofPattern("kk:mm:ss")
}