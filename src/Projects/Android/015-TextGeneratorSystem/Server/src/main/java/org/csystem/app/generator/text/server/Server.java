package org.csystem.app.generator.text.server;

import org.csystem.app.generator.text.server.configuration.random.RandomGeneratorConfig;
import org.csystem.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.random.RandomGenerator;

@Component
public class Server {
    private final ApplicationContext m_applicationContext;
    private final ServerSocket m_serverSocket;
    private final ExecutorService m_threadPool;

    @Value("${server.tcp.timeout}")
    private int m_timeout;

    @Value("${server.tcp.max.len}")
    private int m_maxLength;

    private void handleClient(Socket socket)
    {
        try (socket) {
            var randomGenerator = m_applicationContext.getBean(RandomGenerator.class);
            socket.setSoTimeout(m_timeout);
            var dis = new DataInputStream(socket.getInputStream());
            var dos = new DataOutputStream(socket.getOutputStream());
            var bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));

            System.out.printf("Client connected -> %s:%d\n", socket.getInetAddress().getHostAddress(), socket.getPort());

            var count = dis.readInt();
            var min = dis.readInt();
            var bound = dis.readInt();

            if (bound - min >= m_maxLength) {
                dos.writeInt(0);
                return;
            }

            dos.writeInt(1);

            for (var i = 0; i < count; ++i)
                bw.write(StringUtil.getRandomTextEN(randomGenerator, randomGenerator.nextInt(min, bound)) + "\r\n");

            bw.flush();
        }
        catch (IOException ex) {
            System.err.printf("IO problem occurred:%s%n", ex.getMessage());
        }
        catch (Throwable ex) {
            System.err.printf("Problem occurred:%s%n", ex.getMessage());
        }
    }

    public Server(ApplicationContext applicationContext, ServerSocket serverSocket, ExecutorService threadPool)
    {
        m_applicationContext = applicationContext;
        m_serverSocket = serverSocket;
        m_threadPool = threadPool;
    }

    public void run() throws IOException
    {
        try (m_serverSocket) {
            while (true) {
                System.out.println("Server is waiting for a client");
                var clientSocket = m_serverSocket.accept();
                m_threadPool.execute(() -> handleClient(clientSocket));
            }
        }
    }
}
