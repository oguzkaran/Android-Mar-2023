package org.csystem.app.chatsystem.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record LoginInfoDTO(
        @JsonProperty("login_time")
        LocalDateTime loginDateTime,
        String nickname) {
}
