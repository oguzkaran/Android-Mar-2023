package org.csystem.app.generator.text.server;

import org.csystem.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;

@Component
public class ConfigServer {
    private final ApplicationContext m_applicationContext;
    private final ServerSocket m_serverSocket;
    private final ExecutorService m_threadPool;

    @Value("${server.generate.timeout}")
    private int m_timeout;

    @Value("${server.generate.max.len}")
    private int m_maxLength;

    @Value("${server.config.generate.port}")
    private int m_port;

    private void sendValues(BufferedWriter bw)
    {
        try (bw) {
            bw.write(String.format("Maximum Length:%d, Send Timeout:%d\r\n", m_maxLength, m_timeout));
        }
        catch (IOException ex) {
            System.err.printf("Error occurred while sending values%s%n", ex.getMessage());
        }
    }

    private void handleClient(Socket socket)
    {
        try (socket) {
            var formatter = m_applicationContext.getBean(DateTimeFormatter.class);
            var now = m_applicationContext.getBean(LocalDateTime.class);

            System.out.printf("Config Server: Client connected -> %s:%d on %s\n", socket.getInetAddress().getHostAddress(),
                    socket.getPort(), formatter.format(now));
            sendValues(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8)));
        }
        catch (IOException ex) {
            System.err.printf("IO problem occurred:%s%n", ex.getMessage());
        }
        catch (Throwable ex) {
            System.err.printf("Problem occurred:%s%n", ex.getMessage());
        }
    }

    public ConfigServer(ApplicationContext applicationContext,
                        @Qualifier("generate.config.ServerSocket") ServerSocket serverSocket, ExecutorService threadPool)
    {
        m_applicationContext = applicationContext;
        m_serverSocket = serverSocket;
        m_threadPool = threadPool;
    }

    public void run() throws IOException
    {
        try (m_serverSocket) {
            while (true) {
                System.out.printf("Configuration Server is waiting for a client on port %d%n", m_port);
                var clientSocket = m_serverSocket.accept();
                m_threadPool.execute(() -> handleClient(clientSocket));
            }
        }
    }
}
