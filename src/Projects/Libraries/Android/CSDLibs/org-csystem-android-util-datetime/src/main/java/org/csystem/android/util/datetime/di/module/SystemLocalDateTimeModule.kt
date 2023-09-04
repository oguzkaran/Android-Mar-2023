package org.csystem.android.util.datetime.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import org.csystem.android.util.datetime.di.module.annotation.SystemLocalDateTimeInterceptor
import java.time.LocalDateTime

@Module
@InstallIn(ActivityComponent::class)
object SystemLocalDateTimeModule {
    @Provides
    @SystemLocalDateTimeInterceptor
    fun provideDateTime() : LocalDateTime = LocalDateTime.now()
}