package org.csystem.app.chat.server.configuration.thread

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Configuration
open class ThreadPoolConfig {
    @Bean
    open fun createThreadPool(): ExecutorService
    {
        return Executors.newCachedThreadPool()
    }
}
