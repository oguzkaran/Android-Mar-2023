package org.csystem.android.app.data.service.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.csystem.android.app.data.service.mapper.IUserMapper
import org.csystem.android.app.data.service.mapper.UserMapper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

abstract class UserMapperModule {
    @Binds
    @Singleton
    abstract fun bindUserMapper(userMapper: UserMapper) : IUserMapper
}