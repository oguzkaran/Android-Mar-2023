package org.csystem.android.app.payment.repository

import com.karandev.util.data.repository.ICrudRepository
import org.csystem.android.app.payment.repository.entity.LoginInfo

interface ILoginInfoRepository : ICrudRepository<LoginInfo, Long> {
    fun findByUserName(username: String) : List<LoginInfo>
    fun findSuccessByUserName(username: String) : List<LoginInfo>
    fun findFailsByUserName(username: String) : List<LoginInfo>
    fun findLastSuccessByUserName(username: String) : List<LoginInfo>
    fun findLastFailByUserName(username: String) : List<LoginInfo>
    //...
}