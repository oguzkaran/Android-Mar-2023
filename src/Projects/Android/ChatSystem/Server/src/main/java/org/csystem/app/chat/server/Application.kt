package org.csystem.app.chat.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ComponentScan(basePackages = ["org.csystem"])
@EntityScan(basePackages = ["org.csystem"])
@EnableJpaRepositories("org.csystem")
open class Application

fun main(args: Array<String>)
{
    SpringApplication.run(Application::class.java, *args)
}
