package org.csystem.app.generator.text.server.configuration.socket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.IOException;
import java.net.Socket;

@Configuration
public class SocketConfig {
    @Bean("generate.Socket")
    @Scope("prototype")
    public Socket createGenerateSocket(@Value("${client.generator.host}") String host, @Value("${client.generator.port}")int port) throws IOException
    {
        return new Socket(host, port);
    }

    @Bean("config.Socket")
    @Scope("prototype")
    public Socket createConfiggSocket(@Value("${client.config.generator.host}") String host, @Value("${client.config.generator.port}")int port) throws IOException
    {
        return new Socket(host, port);
    }
}
