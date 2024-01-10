package org.csystem.android.app.generator.random.text.di.datetime.formatter

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.time.format.DateTimeFormatter
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DateTimeFormatterModule {
    @Provides
    @Singleton
    fun create() : DateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME
}