package org.csystem.app.chatsystem.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record LoginInfosDTO(
        @JsonProperty("login_infos")
        List<LoginInfoDTO> loginInfos) {
}
