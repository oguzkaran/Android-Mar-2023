package org.csystem.android.app.geonames.wikisearch.api.di.module

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val BASE_URL = "http://api.geonames.org"
@Module
@InstallIn(SingletonComponent::class)
object GeonamesRetrofitModule {
    @Provides
    @Singleton
    fun create() : Retrofit
    {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .client(OkHttpClient.Builder().build()).build()
    }
}