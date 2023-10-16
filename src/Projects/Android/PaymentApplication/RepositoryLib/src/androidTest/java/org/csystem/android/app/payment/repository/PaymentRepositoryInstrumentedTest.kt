package org.csystem.android.app.payment.repository

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.csystem.android.app.payment.repository.entity.Payment
import org.csystem.android.app.payment.repository.entity.User
import org.csystem.android.app.payment.repository.global.PAYMENT_FILE
import org.csystem.android.app.payment.repository.global.USER_FILE
import org.junit.Assert.*
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import java.io.File
import java.time.LocalDate
import java.time.Month

@RunWith(AndroidJUnit4::class)
//@Ignore("tested before")
class PaymentRepositoryInstrumentedTest {
    companion object {
        val appContext  = InstrumentationRegistry.getInstrumentation().targetContext
        val userRepository = UserRepository(appContext)
        val paymentRepository = PaymentRepository(appContext)
    }

    private fun setUpUsers()
    {
        val user1 = User("alican", "alican1234", "Alican", "Keçici", LocalDate.of(1989, Month.JANUARY, 5), LocalDate.now())
        val user2 = User("umut", "umut123", "Umut", "Utku", "Kırmızıgül", LocalDate.of(1995, Month.OCTOBER, 12), LocalDate.now())

        userRepository.save(user1)
        userRepository.save(user2)
    }

    private fun setUpPayments()
    {
        val payment1 = Payment(1L,"alican", 34.5, 14.6, "Test1")
        val payment2 = Payment(2L,"umut", 40.4, 4.5, "Test2")
        val payment3 = Payment(3L,"alican", 140.4, 14.5, "Test3")
        val payment4 = Payment(4L,"umut", 240.4, 114.5, "Test4")
        val payment5 = Payment(5L,"umut", 340.4, 214.5, "Test5")

        paymentRepository.save(payment1)
        paymentRepository.save(payment2)
        paymentRepository.save(payment3)
        paymentRepository.save(payment4)
        paymentRepository.save(payment5)
    }

    private fun deleteFiles()
    {
        File(appContext.filesDir, USER_FILE).delete()
        File(appContext.filesDir, PAYMENT_FILE).delete()
    }

    @Before
    fun setUp()
    {
        deleteFiles()
        setUpUsers()
        setUpPayments()
    }

    @Test
    fun save_and_findByUserNameSizeTest()
    {
        assertEquals(2, paymentRepository.findByUserName("alican").size)
    }
}