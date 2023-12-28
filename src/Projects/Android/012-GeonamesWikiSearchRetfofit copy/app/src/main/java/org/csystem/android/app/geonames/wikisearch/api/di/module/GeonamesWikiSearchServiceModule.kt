package org.csystem.android.app.geonames.wikisearch.api.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import org.csystem.android.app.geonames.wikisearch.api.IGeonamesWikiSearchService
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
object GeonamesWikiSearchServiceModule {
    @Provides
    fun create(retrofit: Retrofit) : IGeonamesWikiSearchService = retrofit.create(IGeonamesWikiSearchService::class.java)
}