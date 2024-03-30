package org.csystem.app.chat.server

import com.karandev.util.net.TcpUtil
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.csystem.app.chat.server.configuration.constant.ERR_LOGIN
import org.csystem.app.chat.server.configuration.constant.SUC_LOGIN
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.net.ServerSocket
import java.net.Socket
import java.util.concurrent.ExecutorService

@Component
class LoginServer(private val threadPool: ExecutorService,
                  @Qualifier("app.chat.server.config.login.port.ServerSocket")
                     private val serverSocket: ServerSocket) {
    @Value("\${app.chat.server.config.login.timeout}")
    private var mTimeout: Int = 0;

    private fun checkInfo(nickname: String, password: String): Boolean
    {
        return true
    }

    private fun clientOperationCallback(socket: Socket)
    {
        socket.soTimeout = mTimeout
        val nickname = TcpUtil.receiveLine(socket) ?: return
        val password = TcpUtil.receiveLine(socket) ?: return

        val statusMessage = if (checkInfo(nickname, password)) SUC_LOGIN else ERR_LOGIN
        //Save login information to database
        //...
        TcpUtil.sendLine(socket, statusMessage)
    }

    private fun handleClient(socket: Socket)
    {
        try {
            socket.use { clientOperationCallback(it) }
        }
        catch (ex: Throwable) {
            println("Error:${ex.message}")
        }
    }

    private fun serverCallback()
    {
        try {
            println("Login server waiting for a client")

            while (true) {
                val socket = serverSocket.accept()

                MainScope().launch { handleClient(socket) }
            }
        }
        catch (ex: Throwable) {
            println("Exception occurred:${ex.message}")
        }
    }

    fun run()
    {
        threadPool.execute(this::serverCallback)
    }
}