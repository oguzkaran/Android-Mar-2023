package org.csystem.android.app.hillt.module

import android.content.Context
import android.widget.Toast
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.time.format.DateTimeFormatter
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DateTimeFormatterModule {
    @Provides
    @Singleton
    fun provideDateTimeFormatter(@ApplicationContext context: Context) : DateTimeFormatter
    {
        Toast.makeText(context, "provideDateTimeFormatter", Toast.LENGTH_LONG).show()
        return DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm:ss")
    }
}