package org.csystem.android.app.data.service.mapper

import org.csystem.android.app.data.service.dto.UserSaveDTO
import org.csystem.android.app.payment.repository.entity.User

interface IUserMapper {
    fun toUser(userSaveDTO: UserSaveDTO) : User
    fun toUSerSaveDTO(user: User) : UserSaveDTO
}