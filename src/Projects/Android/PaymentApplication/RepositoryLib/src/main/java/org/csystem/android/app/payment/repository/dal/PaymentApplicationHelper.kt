package org.csystem.android.app.payment.repository.dal

import com.karandev.util.data.repository.exception.RepositoryException
import org.csystem.android.app.payment.repository.ILoginInfoRepository
import org.csystem.android.app.payment.repository.dao.IPaymentDao
import org.csystem.android.app.payment.repository.dao.IUserDao
import org.csystem.android.app.payment.repository.entity.LoginInfo
import org.csystem.android.app.payment.repository.entity.Payment
import org.csystem.android.app.payment.repository.entity.User
import org.csystem.android.app.payment.repository.entity.join.UserToPayments
import javax.inject.Inject

class PaymentApplicationHelper @Inject constructor() {
    @Inject
    lateinit var userRepository: IUserDao

    @Inject
    lateinit var loginInfoRepository: ILoginInfoRepository

    @Inject
    lateinit var paymentRepository: IPaymentDao

    fun existsUserByUserName(username: String?): Boolean
    {
        try {
            return userRepository.existsById(username!!)
        }
        catch (ex: Throwable) {
            throw RepositoryException("PaymentApplicationHelper.existsUserByUserName", ex)
        }
    }

    fun existsUserByUserNameAndPassword(username: String, password: String): Boolean
    {
        try {
            return userRepository.existsByUserNameAndPassword(username, password)
        }
        catch (ex: Throwable) {
            throw RepositoryException("PaymentApplicationHelper.existsUserByUserNameAndPassword", ex)
        }
    }

    fun findUserByUserNameAndPassword(username: String, password: String): User?
    {
        try {
            return userRepository.findByUserNameAndPassword(username, password)
        }
        catch (ex: Throwable) {
            throw RepositoryException("PaymentApplicationHelper.findUserByUserNameAndPassword", ex)
        }
    }

    fun saveUser(user: User)
    {
        try {
            userRepository.save(user)
        }
        catch (ex: Throwable) {
            throw RepositoryException("PaymentApplicationHelper.saveUser", ex)
        }
    }

    fun findLoginInfoByUserName(username: String): List<LoginInfo>
    {
        try {
            return loginInfoRepository.findByUserName(username)
        }
        catch (ex: Throwable) {
            throw RepositoryException("PaymentApplicationHelper.findLoginInfoByUserName", ex)
        }
    }

    fun findSuccessLoginInfoByUserName(username: String): List<LoginInfo>
    {
        try {
            return loginInfoRepository.findSuccessByUserName(username)
        }
        catch (ex: Throwable) {
            throw RepositoryException("PaymentApplicationHelper.findSuccessLoginInfoByUserName", ex)
        }
    }

    fun findFailLoginInfoByUserName(userName: String): List<LoginInfo>
    {
        try {
            return loginInfoRepository.findFailsByUserName(userName)
        }
        catch (ex: Throwable) {
            throw RepositoryException("PaymentApplicationHelper.findFailLoginInfoByUserName", ex)
        }
    }

    fun saveLoginInfo(loginInfo: LoginInfo) : LoginInfo
    {
        try {
            return loginInfoRepository.save(loginInfo)
        }
        catch (ex: Throwable) {
            throw RepositoryException("PaymentApplicationHelper.saveLoginInfo", ex)
        }
    }

    fun findPaymentsByUserName(userName: String): List<UserToPayments>
    {
        try {
            return paymentRepository.findByUserName(userName)
        }
        catch (ex: Throwable) {
            throw RepositoryException("PaymentApplicationHelper.findPaymentsByUserName", ex)
        }
    }

    fun savePayment(payment: Payment)
    {
        try {
            paymentRepository.save(payment)
        }
        catch (ex: Throwable) {
            throw RepositoryException("PaymentApplicationHelper.savePayment", ex)
        }
    }

    //...
}