package org.csystem.app.generator.text.server.configuration.datetime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class DateTimeConfig {
    @Bean
    @Scope("prototype")
    public LocalDateTime createDateTime()
    {
        return LocalDateTime.now();
    }
}
