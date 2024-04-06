package org.csystem.app.chatsystem.service.mapper;

import org.csystem.app.chatsystem.repository.entity.LoginInfo;
import org.csystem.app.chatsystem.service.dto.LoginInfoDTO;
import org.csystem.app.chatsystem.service.dto.LoginInfosDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(implementationName = "LoginInfoMapperImpl", componentModel = "spring")
public interface ILoginInfoMapper {

    @Mapping(source = "loginInfo.user.nickName", target = "nickname")
    LoginInfoDTO toLoginInfoDTO(LoginInfo loginInfo);

    default LoginInfosDTO toLoginInfosDTO(List<LoginInfoDTO> loginInfoDTOs)
    {
        return new LoginInfosDTO(loginInfoDTOs);
    }
}
