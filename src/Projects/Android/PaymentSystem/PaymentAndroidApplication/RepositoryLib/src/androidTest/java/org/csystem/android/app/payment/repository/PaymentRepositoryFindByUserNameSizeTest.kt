package org.csystem.android.app.payment.repository

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.csystem.android.app.payment.repository.database.PaymentApplicationDatabase
import org.csystem.android.app.payment.repository.entity.Payment
import org.csystem.android.app.payment.repository.entity.User
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.File
import java.time.LocalDate
import java.time.Month

@RunWith(AndroidJUnit4::class)
class PaymentRepositoryFindByUserNameSizeTest {
    companion object {
        private val appContext  = InstrumentationRegistry.getInstrumentation().targetContext
        private var database = Room.databaseBuilder(appContext, PaymentApplicationDatabase::class.java, "paymentdb-test.sqlite3").build()
        private val userDao = database.createUserDao()
        private val paymentDao = database.createPaymentDao()
    }

    private fun setUpUsers()
    {
        val user1 = User("alican", "alican1234", "Alican", "Keçici", LocalDate.of(1989, Month.JANUARY, 5), LocalDate.now())
        val user2 = User("umut", "umut123", "Umut", "Utku", "Kırmızıgül", LocalDate.of(1995, Month.OCTOBER, 12), LocalDate.now())

        userDao.save(user1)
        userDao.save(user2)
    }

    private fun setUpPayments()
    {
        val payment1 = Payment(1L,"alican", 34.5, 14.6, "Test1")
        val payment2 = Payment(2L,"umut", 40.4, 4.5, "Test2")
        val payment3 = Payment(3L,"alican", 140.4, 14.5, "Test3")
        val payment4 = Payment(4L,"umut", 240.4, 114.5, "Test4")
        val payment5 = Payment(5L,"umut", 340.4, 214.5, "Test5")

        paymentDao.save(payment1)
        paymentDao.save(payment2)
        paymentDao.save(payment3)
        paymentDao.save(payment4)
        paymentDao.save(payment5)
    }

    private fun deleteFiles()
    {
        val files = File(appContext.dataDir, "databases").listFiles()

        if (files != null)
            for (file in files)
                file.delete()
    }

    @Before
    fun setUp()
    {
        deleteFiles()
        setUpUsers()
        setUpPayments()
    }

    @Test
    fun test()
    {
        assertEquals(2, paymentDao.findByUserName("alican").size)
    }
}