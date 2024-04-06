package org.csystem.app.chatsystem.service.mapper;

import org.csystem.app.chatsystem.repository.entity.User;
import org.csystem.app.chatsystem.service.dto.LoginInfosDTO;
import org.csystem.app.chatsystem.service.dto.UserDTO;
import org.csystem.app.chatsystem.service.dto.UserSaveDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "UserMapperImpl", componentModel = "spring")
public interface IUserMapper {

    User toUser(UserSaveDTO userSaveDTO);

    @Mapping(target = "loginInfosDTOs", source = "loginInfosDTO")
    UserDTO toUserDTO(User user, LoginInfosDTO loginInfosDTO);
}
