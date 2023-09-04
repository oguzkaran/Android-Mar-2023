package org.csystem.android.util.datetime.di.module.formatter

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.csystem.android.util.datetime.di.module.formatter.annotation.LocalDateFormatterInterceptor
import java.time.format.DateTimeFormatter
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDateFormatterModule {
    @Provides
    @Singleton
    @LocalDateFormatterInterceptor
    fun provideFormatter() : DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
}