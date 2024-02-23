package org.csystem.app.generator.text.server.configuration.socket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.ServerSocket;

@Configuration
public class ServerSocketConfig {
    @Bean("generate.ServerSocket")
    public ServerSocket createGenerateServerSocket(@Value("${server.generate.port}")int port, @Value("${server.generate.backlog}") int backlog) throws IOException
    {
        return new ServerSocket(port, backlog);
    }

    @Bean("generate.config.ServerSocket")
    public ServerSocket createConfigerverSocket(@Value("${server.config.generate.port}")int port, @Value("${server.config.generate.backlog}") int backlog) throws IOException
    {
        return new ServerSocket(port, backlog);
    }
}
