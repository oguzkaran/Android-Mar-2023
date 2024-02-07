package org.csystem.app.generator.text.server.configuration.socket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.IOException;
import java.net.Socket;

@Configuration
public class SocketConfig {
    @Bean
    @Scope("prototype")
    public Socket createSocket(@Value("${client.tcp.host}") String host, @Value("${client.tcp.port}")int port) throws IOException
    {
        return new Socket(host, port);
    }
}
