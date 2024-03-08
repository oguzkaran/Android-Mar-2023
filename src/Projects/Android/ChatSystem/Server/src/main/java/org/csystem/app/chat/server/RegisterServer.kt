package org.csystem.app.chat.server

import com.karandev.util.net.TcpUtil
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.net.ServerSocket
import java.net.Socket
import java.util.concurrent.ExecutorService

@Component
class RegisterServer(private val threadPool: ExecutorService,
                     @Qualifier("app.chat.server.config.register.port.ServerSocket")
                     private val serverSocket: ServerSocket) {
    @Value("\${app.chat.server.config.register.timeout}")
    private var mTimeout: Int = 0;
    private fun handleClient(socket: Socket)
    {
        socket.soTimeout = mTimeout
        val name = TcpUtil.receiveStringViaLength(socket)
        val email = TcpUtil.receiveStringViaLength(socket)
        val nickname = TcpUtil.receiveStringViaLength(socket)
        val password = TcpUtil.receiveStringViaLength(socket)

        //...

        TcpUtil.sendStringViaLength(socket, "Success")
    }

    private fun serverCallback()
    {
        try {
            println("Register server waiting for a client")

            while (true) {
                val socket = serverSocket.accept()

                threadPool.execute{handleClient(socket)}
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