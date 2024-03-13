package org.csystem.app.generator.text.server.configuration.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Configuration
public class ThreadPoolConfig {
    @Bean("threadpool")
    public ExecutorService createThreadPool()
    {
        return Executors.newSingleThreadExecutor();
    }

    @Bean
    public ScheduledExecutorService createScheduledExecutorService()
    {
        return Executors.newScheduledThreadPool(10);
    }
}
