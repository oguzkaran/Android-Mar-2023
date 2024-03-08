package org.csystem.app.chat.server.configuration.datetime

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.format.DateTimeFormatter

@Configuration
open class DateTimeFormatterConfig {
    @Bean
    open fun createFormatter(): DateTimeFormatter
    {
        return DateTimeFormatter.ISO_DATE_TIME
    }
}
