package org.csystem.app.chatsystem.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserDTO(
        @JsonProperty("nick_name")
        String nickName,
        String name,
        @JsonProperty("login_infos")
        LoginInfosDTO loginInfosDTOs) {
}
