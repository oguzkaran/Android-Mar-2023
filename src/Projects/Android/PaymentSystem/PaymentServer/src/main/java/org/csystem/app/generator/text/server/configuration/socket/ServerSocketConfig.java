package org.csystem.app.generator.text.server.configuration.socket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.ServerSocket;

@Configuration
public class ServerSocketConfig {
    @Bean
    public ServerSocket createServerSocket(@Value("${server.tcp.port}")int port, @Value("${server.tcp.backlog}") int backlog) throws IOException
    {
        return new ServerSocket(port, backlog);
    }
}
