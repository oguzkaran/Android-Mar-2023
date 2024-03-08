package org.csystem.app.chat.server.configuration.socket

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.net.ServerSocket

@Configuration
open class ServerSocketConfig {
    @Bean("app.chat.server.config.register.port.ServerSocket")
    open fun createRegisterServerSocket(
        @Value("\${app.chat.server.config.register.port}") port: Int,
        @Value("\${app.chat.server.config.register.port}") backlog: Int
    ): ServerSocket
    {
        return ServerSocket(port, backlog)
    }
}
