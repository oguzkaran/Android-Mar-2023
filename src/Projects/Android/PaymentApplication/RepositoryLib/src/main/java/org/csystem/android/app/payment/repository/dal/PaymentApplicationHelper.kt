package org.csystem.android.app.payment.repository.dal

import com.karandev.util.data.repository.exception.RepositoryException
import org.csystem.android.app.payment.repository.dao.ILoginInfoDao
import org.csystem.android.app.payment.repository.dao.IPaymentDao
import org.csystem.android.app.payment.repository.dao.IUserDao

import org.csystem.android.app.payment.repository.entity.LoginInfo
import org.csystem.android.app.payment.repository.entity.Payment
import org.csystem.android.app.payment.repository.entity.User

import javax.inject.Inject

class PaymentApplicationHelper @Inject constructor() {
    @Inject
    lateinit var userDao: IUserDao

    @Inject
    lateinit var loginInfoDao: ILoginInfoDao

    @Inject
    lateinit var paymentDao: IPaymentDao

    fun existsUserByUserName(username: String?): Boolean
    {
        try {
            return userDao.existsById(username!!)
        }
        catch (ex: Throwable) {
            throw RepositoryException("PaymentApplicationHelper.existsUserByUserName", ex)
        }
    }

    fun existsUserByUserNameAndPassword(username: String, password: String): Boolean
    {
        try {
            return userDao.existsByUserNameAndPassword(username, password)
        }
        catch (ex: Throwable) {
            throw RepositoryException("PaymentApplicationHelper.existsUserByUserNameAndPassword", ex)
        }
    }

    fun findUserByUserNameAndPassword(username: String, password: String): User?
    {
        try {
            return userDao.findByUserNameAndPassword(username, password)
        }
        catch (ex: Throwable) {
            throw RepositoryException("PaymentApplicationHelper.findUserByUserNameAndPassword", ex)
        }
    }

    fun saveUser(user: User)
    {
        try {
            userDao.save(user)
        }
        catch (ex: Throwable) {
            throw RepositoryException("PaymentApplicationHelper.saveUser", ex)
        }
    }

    fun findLoginInfoByUserName(username: String): List<LoginInfo>
    {
        try {
            return loginInfoDao.findByUserName(username)
        }
        catch (ex: Throwable) {
            throw RepositoryException("PaymentApplicationHelper.findLoginInfoByUserName", ex)
        }
    }

    fun findSuccessLoginInfoByUserName(username: String): List<LoginInfo>
    {
        try {
            return loginInfoDao.findSuccessByUserName(username)
        }
        catch (ex: Throwable) {
            throw RepositoryException("PaymentApplicationHelper.findSuccessLoginInfoByUserName", ex)
        }
    }

    fun findFailLoginInfoByUserName(userName: String): List<LoginInfo>
    {
        try {
            return loginInfoDao.findFailsByUserName(userName)
        }
        catch (ex: Throwable) {
            throw RepositoryException("PaymentApplicationHelper.findFailLoginInfoByUserName", ex)
        }
    }

    fun saveLoginInfo(loginInfo: LoginInfo)
    {
        try {
            loginInfoDao.save(loginInfo)
        }
        catch (ex: Throwable) {
            throw RepositoryException("PaymentApplicationHelper.saveLoginInfo", ex)
        }
    }

    /*
    fun findPaymentsByUserName(userName: String): List<User>
    {
        try {
            return paymentDao.findByUserName(userName)
        }
        catch (ex: Throwable) {
            throw RepositoryException("PaymentApplicationHelper.findPaymentsByUserName", ex)
        }
    }

     */

    fun savePayment(payment: Payment)
    {
        try {
            paymentDao.save(payment)
        }
        catch (ex: Throwable) {
            throw RepositoryException("PaymentApplicationHelper.savePayment", ex)
        }
    }

    //...
}