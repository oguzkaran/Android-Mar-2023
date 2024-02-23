package org.csystem.app.generator.text.server.configuration.datetime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class DateTimeFormatterConfig {
    @Bean
    public DateTimeFormatter createFormatter()
    {
        return DateTimeFormatter.ISO_DATE_TIME;
    }
}
