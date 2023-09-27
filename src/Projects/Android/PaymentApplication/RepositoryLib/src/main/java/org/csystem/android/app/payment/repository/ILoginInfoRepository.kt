package org.csystem.android.app.payment.repository

import com.karandev.util.data.repository.ICrudRepository
import org.csystem.android.app.payment.repository.entity.LoginInfo

interface ILoginInfoRepository : ICrudRepository<LoginInfo, Long> {
    fun findByUserName(userName: String) : List<LoginInfo>
    fun findSuccessByUserName(userName: String) : List<LoginInfo>

    fun findFailsByUserName(userName: String) : List<LoginInfo>
    fun findLastSuccessByUserName(userName: String) : List<LoginInfo>
    fun findLastFailByUserName(userName: String) : List<LoginInfo>
    //...
}