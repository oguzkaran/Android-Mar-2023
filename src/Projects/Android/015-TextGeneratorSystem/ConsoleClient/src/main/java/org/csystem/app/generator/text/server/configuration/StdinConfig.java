package org.csystem.app.generator.text.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class StdinConfig {
    @Bean
    public Scanner createScanner()
    {
        return new Scanner(System.in);
    }
}
