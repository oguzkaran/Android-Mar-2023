package org.csystem.android.app.data.service.mapper

import org.csystem.android.app.data.service.dto.UserSaveDTO
import org.csystem.android.app.payment.repository.entity.User
import java.time.LocalDate
import javax.inject.Inject

class UserMapper @Inject constructor() : IUserMapper {
    override fun toUser(userSaveDTO: UserSaveDTO): User
    {
        return User(userSaveDTO.username, userSaveDTO.password, userSaveDTO.firstName, userSaveDTO.middleName, userSaveDTO.lastName, userSaveDTO.birthDate, LocalDate.now())
    }

    override fun toUSerSaveDTO(user: User): UserSaveDTO
    {
        return UserSaveDTO(user.username, user.password, user.firstName, user.lastName, user.birthDate, user.middleName)
    }
}