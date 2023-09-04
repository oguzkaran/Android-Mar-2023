package org.csystem.android.util.datetime.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import org.csystem.android.util.datetime.di.module.annotation.SystemLocalDateInterceptor
import java.time.LocalDate

@Module
@InstallIn(ActivityComponent::class)
object SystemLocalDateModule {
    @Provides
    @SystemLocalDateInterceptor
    fun provideLocalDate() : LocalDate = LocalDate.now()
}