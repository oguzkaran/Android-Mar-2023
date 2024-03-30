package org.csystem.app.chat.server.runner

import org.csystem.app.chat.server.LoginServer
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.util.concurrent.ExecutorService

@Component
class LoginServerRunner(private val threadPool: ExecutorService, private val loginServer: LoginServer) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) = threadPool.execute(loginServer::run)
}