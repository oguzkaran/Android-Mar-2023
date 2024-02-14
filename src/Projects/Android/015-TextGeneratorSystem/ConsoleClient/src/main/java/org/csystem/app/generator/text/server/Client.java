package org.csystem.app.generator.text.server;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.stream.Stream;

@Component
public class Client {
    private final ApplicationContext m_applicationContext;

    private final Scanner m_stdin;

    private String readTextCallback(BufferedReader br)
    {
        var result = "";

        try {
            result = br.readLine();
        }
        catch (IOException ex) {
            System.err.printf("Error occurred while receiving text:%s%n", ex.getMessage());
        }

        return result;
    }

    private void doSendAndGetMessage(int count, int min, int bound)
    {
        try (var socket = m_applicationContext.getBean(Socket.class)) {
            var dos = new DataOutputStream(socket.getOutputStream());
            var dis = new DataInputStream(socket.getInputStream());
            var br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

            dos.writeInt(count);
            dos.writeInt(min);
            dos.writeInt(bound);

            if (dis.readInt() == 0) {
                System.out.printf("Invalid values:%s%n", br.readLine());
                return;
            }

            Stream.generate(() -> readTextCallback(br)).limit(count).forEach(text -> System.out.printf("Text:%s\n", text));
        }
        catch (IOException ex) {
            System.err.printf("Error occurred:%s%n", ex.getMessage());
        }
    }


    public Client(ApplicationContext applicationContext, Scanner stdin)
    {
        m_applicationContext = applicationContext;
        m_stdin = stdin;
    }

    public void run() throws IOException
    {
        while (true) {
            System.out.print("Input count, min and bound:");
            int count = m_stdin.nextInt();
            int min = m_stdin.nextInt();
            int bound = m_stdin.nextInt();

            doSendAndGetMessage(count, min, bound);

            if (count == 0 && min == 0 && bound == 0)
                break;
        }
    }
}
