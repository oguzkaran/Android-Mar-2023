package org.csystem.app.chat.server.configuration.datetime

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import java.time.LocalDateTime

@Configuration
open class DateTimeConfig {
    @Bean
    @Scope("prototype")
    open fun createDateTime(): LocalDateTime
    {
        return LocalDateTime.now()
    }
}
