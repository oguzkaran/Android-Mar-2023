package org.csystem.android.app.payment.repository

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.csystem.android.app.payment.repository.dao.IUserDao
import org.csystem.android.app.payment.repository.database.PaymentApplicationDatabase
import org.csystem.android.app.payment.repository.entity.User
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import java.io.File
import java.time.LocalDate
import java.time.Month

@RunWith(AndroidJUnit4::class)
class UserRepositoryInstrumentedTest {
    companion object {
        private val appContext  = InstrumentationRegistry.getInstrumentation().targetContext
    }

    var database: PaymentApplicationDatabase? = null
    private lateinit var userDao : IUserDao

    private fun createDatabase()
    {
        database = Room.databaseBuilder(appContext, PaymentApplicationDatabase::class.java, "paymentdb-test.sqlite3").build()
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

    private fun saveUsers()
    {
        val user1 = User("alican", "alican1234", "Alican", "Keçici", LocalDate.of(1989, Month.JANUARY, 5), LocalDate.now())
        val user2 = User("umut", "umut123", "Umut", "Utku", "Kırmızıgül", LocalDate.of(1995, Month.OCTOBER, 12), LocalDate.now())

        userDao.save(user1)
        userDao.save(user2)
    }

    private fun initialize()
    {
        deleteDatabaseFiles()
        saveUsers()
    }

    @Test
    fun save_and_findByUserNameAndPasswordSuccessTest()
    {
        initialize()
        assertNotNull(userDao.findByUserNameAndPassword("umut", "umut123"))
    }

    @Test
    fun save_and_findByUserNameAndPasswordPasswordFailTest()
    {
        initialize()
        assertNull(userDao.findByUserNameAndPassword("alican", "alican123"))
    }

    @Test
    fun save_and_findByUserNameAndPasswordUsernameFailTest()
    {
        initialize()
        assertNull(userDao.findByUserNameAndPassword("baturhan", "alican1234"))
    }

    @Test
    fun save_and_findByUserNameAndPasswordBothFailTest()
    {
        initialize()
        assertNull(userDao.findByUserNameAndPassword("baturhan", "baturhan"))
    }

    @Test
    fun existsByUserNameAndPasswordSuccessTest()
    {
        initialize()
        assertTrue(userDao.existsByUserNameAndPassword("umut", "umut123"))
    }

    @Test
    fun existsByUserNameAndPasswordPasswordFailTest()
    {
        initialize()
        assertFalse(userDao.existsByUserNameAndPassword("umut", "umut12"))
    }

    @Test
    fun existsByUserNameAndPasswordUsernameFailTest()
    {
        initialize()
        assertFalse(userDao.existsByUserNameAndPassword("umu", "umut123"))
    }

    @Test
    fun existsByUserNameAndPasswordBothFailTest()
    {
        initialize()
        assertFalse(userDao.existsByUserNameAndPassword("erkan", "erkan123"))
    }
}