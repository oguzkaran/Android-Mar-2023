package org.csystem.app.chat.server

import com.karandev.util.net.TcpUtil
import com.karandev.util.net.exception.NetworkException
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.csystem.app.chat.server.configuration.constant.*
import org.csystem.app.chatsystem.service.ChatSystemService
import org.csystem.app.chatsystem.service.dto.UserSaveDTO
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.net.ServerSocket
import java.net.Socket
import java.util.concurrent.ExecutorService

@Component
class RegisterServer(private val threadPool: ExecutorService,
                     @Qualifier("app.chat.server.config.register.port.ServerSocket")
                     private val serverSocket: ServerSocket,
                     private val chatSystemService: ChatSystemService) {
    @Value("\${app.chat.server.config.register.timeout}")
    private var mTimeout: Int = 0;

    private fun clientOperationCallback(socket: Socket)
    {
        try {
            socket.soTimeout = mTimeout
            val name = TcpUtil.receiveLine(socket)
            val nickname = TcpUtil.receiveLine(socket)
            val password = TcpUtil.receiveLine(socket)
            val confirmPassword = TcpUtil.receiveLine(socket)

            if (name.isBlank()) {
                TcpUtil.sendLine(socket, ERR_NAME_BLANK)
                return
            }

            if (nickname.isBlank()) {
                TcpUtil.sendLine(socket, ERR_NICKNAME_BLANK)
                return
            }

            if (password.isBlank()) {
                TcpUtil.sendLine(socket, ERR_PASSWORD_BLANK)
                return
            }

            if (password != confirmPassword) {
                TcpUtil.sendLine(socket, ERR_CONFIRM_PASSWORD)
                return
            }

            val user = UserSaveDTO(nickname, name, password)

            chatSystemService.saveUser(user)
            TcpUtil.sendLine(socket, SUC_REGISTER)
        }
        catch (ex: NetworkException) {
            println("Network Error:${ex.message}")
        }
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
            println("Register server waiting for a client")

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