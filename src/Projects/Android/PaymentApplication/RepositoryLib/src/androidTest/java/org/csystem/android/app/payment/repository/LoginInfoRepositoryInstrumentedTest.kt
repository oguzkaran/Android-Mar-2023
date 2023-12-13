package org.csystem.android.app.payment.repository

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.csystem.android.app.payment.repository.dao.ILoginInfoDao
import org.csystem.android.app.payment.repository.dao.IUserDao
import org.csystem.android.app.payment.repository.database.PaymentApplicationDatabase
import org.csystem.android.app.payment.repository.entity.LoginInfo
import org.csystem.android.app.payment.repository.entity.User
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import java.io.File
import java.time.LocalDate
import java.time.Month

@RunWith(AndroidJUnit4::class)
class LoginInfoRepositoryInstrumentedTest {
    companion object {
        private val appContext  = InstrumentationRegistry.getInstrumentation().targetContext
    }

    var database: PaymentApplicationDatabase? = null
    private lateinit var loginInfoDao : ILoginInfoDao
    private lateinit var userDao: IUserDao

    private fun createDatabase()
    {
        database = Room.databaseBuilder(appContext, PaymentApplicationDatabase::class.java, "paymentdb-test.sqlite3").build()
        loginInfoDao = database!!.createLoginInfoDao()
        userDao = database!!.createUserDao()
    }

    private fun deleteDatabaseFiles()
    {
        if (database != null)
            database!!.close()

        createDatabase()
        val files = File(appContext.dataDir, "databases").listFiles()

        if (files != null)
            for (file in files)
                file.delete()
    }

    private fun saveData()
    {
        val user1 = User("alican", "alican1234", "Alican", "Keçici", LocalDate.of(1989, Month.JANUARY, 5), LocalDate.now())
        val user2 = User("umut", "umut123", "Umut", "Utku", "Kırmızıgül", LocalDate.of(1995, Month.OCTOBER, 12), LocalDate.now())

        userDao.save(user1)
        userDao.save(user2)

        val loginInfo1 = LoginInfo(1, "alican", success = true)
        val loginInfo2 = LoginInfo(2, "umut", success = true)
        val loginInfo4 = LoginInfo(3, "umut", success = false)

        loginInfoDao.save(loginInfo1)
        loginInfoDao.save(loginInfo2)
        loginInfoDao.save(loginInfo4)

    }

    private fun initialize()
    {
        deleteDatabaseFiles()
        saveData()
    }

    @Test
    fun findByUserNameAndSuccessLoginCountTest()
    {
        initialize()
        assertEquals(1, loginInfoDao.findSuccessByUserName("alican").size)
    }

    @Test
    fun findByUserNameAndFailLoginCountTest()
    {
        initialize()
        assertEquals(1, loginInfoDao.findFailsByUserName("umut").size)
    }

    @Test
    fun findByUserName_UsernameTrueTest()
    {
        initialize()
        assertEquals(2, loginInfoDao.findByUserName("umut").size)
    }

    @Test
    fun findByUserName_UserNameFalseTest()
    {
        initialize()
        assertEquals(0, loginInfoDao.findByUserName("baturhan").size)
    }
}