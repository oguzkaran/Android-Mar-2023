package org.csystem.android.app.data.service.mapper.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.csystem.android.app.data.service.mapper.IUserMapper
import org.csystem.android.app.data.service.mapper.di.module.annotation.UserMapperInterceptor
import org.mapstruct.factory.Mappers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserMapperModule {
    @Provides
    @Singleton
    @UserMapperInterceptor
    fun provideUserMapper() : IUserMapper = Mappers.getMapper(IUserMapper::class.java)
}