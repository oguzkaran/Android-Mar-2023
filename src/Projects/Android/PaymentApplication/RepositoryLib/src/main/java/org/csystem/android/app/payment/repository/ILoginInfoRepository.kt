package org.csystem.android.app.payment.repository

import com.karandev.util.data.repository.ICrudRepository
import org.csystem.android.app.payment.repository.entity.LoginInfo

interface ILoginInfoRepository : ICrudRepository<LoginInfo, Long> {
    //...
}