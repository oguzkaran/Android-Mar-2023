package org.csystem.android.app.payment.repository

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.csystem.android.app.payment.repository.entity.User
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
@Ignore("tested before")
class UserRepositoryInstrumentedTest {
    companion object {
        val appContext  = InstrumentationRegistry.getInstrumentation().targetContext
        val userRepository = UserRepository(appContext)
    }

    @Before
    fun setUp()
    {
        val file = File(appContext.filesDir, USER_FILE)

        file.delete();
        val user1 = User("alican", "alican1234", "Alican", "Keçici", LocalDate.of(1989, Month.JANUARY, 5), LocalDate.now())
        val user2 = User("umut", "umut123", "Umut", "Utku", "Kırmızıgül", LocalDate.of(1995, Month.OCTOBER, 12), LocalDate.now())

        userRepository.save(user1)
        userRepository.save(user2)
    }

    @Test
    fun save_and_findByUserNameAndPasswordSuccessTest()
    {
        assertNotNull(userRepository.findByUserNameAndPassword("umut", "umut123"))
    }

    @Test
    fun save_and_findByUserNameAndPasswordPasswordFailTest()
    {
        assertNull(userRepository.findByUserNameAndPassword("alican", "alican123"))
    }

    @Test
    fun save_and_findByUserNameAndPasswordUsernameFailTest()
    {
        assertNull(userRepository.findByUserNameAndPassword("baturhan", "alican1234"))
    }

    @Test
    fun save_and_findByUserNameAndPasswordBothFailTest()
    {
        assertNull(userRepository.findByUserNameAndPassword("baturhan", "baturhan"))
    }
}