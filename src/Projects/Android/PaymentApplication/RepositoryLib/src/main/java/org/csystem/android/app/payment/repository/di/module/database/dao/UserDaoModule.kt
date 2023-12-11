import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.csystem.android.app.payment.repository.dao.IUserDao
import org.csystem.android.app.payment.repository.database.PaymentApplicationDatabase
import org.csystem.android.app.payment.repository.di.module.database.PaymentApplicationDatabaseInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserDaoModule {
    @Provides
    @Singleton
    fun createUserDao(@PaymentApplicationDatabaseInterceptor paymentApplicationDatabase: PaymentApplicationDatabase) : IUserDao
    {
        return paymentApplicationDatabase.createUserDao()
    }
}