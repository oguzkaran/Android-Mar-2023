package org.csystem.android.app.data.service

import com.karandev.util.data.repository.exception.RepositoryException
import com.karandev.util.data.service.DataServiceException
import org.csystem.android.app.data.service.dto.LoginInfoDTO
import org.csystem.android.app.data.service.dto.UserSaveDTO
import org.csystem.android.app.data.service.mapper.ILoginInfoMapper
import org.csystem.android.app.data.service.mapper.IUserMapper
import org.csystem.android.app.data.service.mapper.di.module.annotation.UserMapperInterceptor
import org.csystem.android.app.payment.repository.dal.PaymentApplicationHelper
import javax.inject.Inject

class PaymentApplicationDataService @Inject constructor(
    paymentApplicationHelper: PaymentApplicationHelper,
    @UserMapperInterceptor userMapper: IUserMapper,
    loginInfoMapper: ILoginInfoMapper) {
    private val mPaymentApplicationHelper = paymentApplicationHelper
    private val mUserMapper = userMapper
    private val mLoginInfoMapper = loginInfoMapper

    fun checkAndSaveLoginInfo(loginInfoDTO: LoginInfoDTO) : Boolean
    {
        try { //Aşağıdaki kodlar DAL katmanına da eklenebilir
            if (!mPaymentApplicationHelper.existsUserByUserName(loginInfoDTO.username))
                return false;

            val loginInfo = mLoginInfoMapper.toLoginInfo(loginInfoDTO);

            if (mPaymentApplicationHelper.existsUserByUserNameAndPassword(loginInfoDTO.username, loginInfoDTO.password))
                mPaymentApplicationHelper.saveLoginInfo(loginInfo)
            else
                mPaymentApplicationHelper.saveLoginInfo(loginInfo.also { it.success = false })

            return loginInfo.success;
        }
        catch (ex: RepositoryException) {
            throw DataServiceException("PaymentApplicationDataService.checkAndSaveLoginInfo", ex.cause)
        }
        catch (ex: Throwable) {
            throw DataServiceException("PaymentApplicationDataService.checkAndSaveLoginInfo", ex)
        }
    }

    fun saveUser(userSaveDTO: UserSaveDTO) : Boolean
    {
        try {
            mPaymentApplicationHelper.saveUser(mUserMapper.toUser(userSaveDTO))
            return true
        }
        catch (ex: RepositoryException) {
            throw DataServiceException("PaymentApplicationDataService.saveUser", ex.cause)
        }
        catch (ex: Throwable) {
            throw DataServiceException("PaymentApplicationDataService.saveUser", ex)
        }
    }

    //...
}