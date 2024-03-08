package org.csystem.app.chat.server.runner

import org.csystem.app.chat.server.RegisterServer
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.util.concurrent.ExecutorService

@Component
class RegisterServerRunner(private val threadPool: ExecutorService, private val registerServer: RegisterServer) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) = threadPool.execute(registerServer::run)
}