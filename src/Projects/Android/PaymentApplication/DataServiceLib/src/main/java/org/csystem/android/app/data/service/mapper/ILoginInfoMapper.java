package org.csystem.android.app.data.service.mapper;

import org.csystem.android.app.data.service.dto.LoginInfoDTO;
import org.csystem.android.app.payment.repository.entity.LoginInfo;
import org.mapstruct.Mapper;

@Mapper(implementationName = "LoginInfoMapperImpl")
public interface ILoginInfoMapper {
    LoginInfo toLoginInfo(LoginInfoDTO loginInfoDTO);
}
