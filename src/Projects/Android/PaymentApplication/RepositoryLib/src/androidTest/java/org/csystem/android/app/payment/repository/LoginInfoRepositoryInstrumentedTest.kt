package org.csystem.android.app.payment.repository

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.csystem.android.app.payment.repository.LoginInfoRepository.*
import org.csystem.android.app.payment.repository.entity.LoginInfo
import org.csystem.android.app.payment.repository.global.LOGIN_INFO_FILE
import org.junit.Assert.*
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import java.io.File

@RunWith(AndroidJUnit4::class)
@Ignore("tested before")
class LoginInfoRepositoryInstrumentedTest {
    companion object {
        val appContext  = InstrumentationRegistry.getInstrumentation().targetContext
        val loginInfoRepository = LoginInfoRepository(appContext)
    }

    @Before
    fun setUp()
    {
        val file = File(appContext.filesDir, LOGIN_INFO_FILE)

        file.delete()

        val loginInfo1 = LoginInfo(1, "alican1234", success = true)
        val loginInfo2 = LoginInfo(2, "umut123", success = true)
        val loginInfo4 = LoginInfo(3, "umut123", success = false)

        loginInfoRepository.save(loginInfo1)
        loginInfoRepository.save(loginInfo2)
        loginInfoRepository.save(loginInfo4)
    }

    @Test
    fun findByUserNameAndSuccessLoginCountTest()
    {
        assertEquals(1, loginInfoRepository.findSuccessByUserName("alican1234").size)
    }

    @Test
    fun findByUserNameAndFailLoginCountTest()
    {
        assertEquals(1, loginInfoRepository.findFailsByUserName("umut123").size)
    }

    @Test
    fun findByUserName_UsernameTrueTest()
    {
        assertEquals(2, loginInfoRepository.findByUserName("umut123").size)
    }

    @Test
    fun findByUserName_UserNameFalseTest()
    {
        assertEquals(0, loginInfoRepository.findByUserName("baturhan").size)
    }

}