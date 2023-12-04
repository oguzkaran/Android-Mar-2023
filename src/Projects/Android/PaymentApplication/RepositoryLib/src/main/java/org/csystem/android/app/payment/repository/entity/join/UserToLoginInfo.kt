package org.csystem.android.app.payment.repository.entity.join

import androidx.room.Embedded
import androidx.room.Relation
import org.csystem.android.app.payment.repository.entity.LoginInfo
import org.csystem.android.app.payment.repository.entity.User

data class UserToLoginInfo(@Embedded val user: User,
                           @Relation(parentColumn = "username", entityColumn = "username")
                            var loginInfoList: List<LoginInfo>)
