package org.csystem.app.generator.text.server;

import com.karandev.util.net.TcpUtil;
import com.karandev.util.net.UdpUtil;
import com.karandev.util.net.exception.NetworkException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Component
public class Client {
    private final ApplicationContext m_applicationContext;
    private final ScheduledExecutorService m_scheduledExecutorService;
    private final Scanner m_stdin;

    private int m_periodicSender = 1;


    @Value("${client.periodic.message.host}")
    private String m_periodicHost;

    @Value("${client.periodic.message.port}")
    private int m_periodicPort;

    private String readTextCallback(Socket socket)
    {
        var result = "";

        try {
            result = TcpUtil.receiveStringViaLength(socket).strip();
        }
        catch (NetworkException ex) {
            System.err.printf("Error occurred while receiving text:%s%n", ex.getMessage());
        }

        return result;
    }

    private void doSendAndGetMessage(int count, int min, int bound)
    {
        try (var socket = m_applicationContext.getBean("generate.Socket", Socket.class)) {
            TcpUtil.sendInt(socket, count);
            TcpUtil.sendInt(socket, min);
            TcpUtil.sendInt(socket, bound);

            if (TcpUtil.receiveInt(socket) == 0) {
                System.out.printf("Invalid values:%s%n", TcpUtil.receiveStringViaLength(socket).strip());
                return;
            }

            Stream.generate(() -> readTextCallback(socket)).limit(count).forEach(text -> System.out.printf("Text:%s\n", text));
        }
        catch (IOException ex) {
            System.err.printf("Error occurred:%s%n", ex.getMessage());
        }
    }

    private void doGetConfig()
    {
        try (var socket = m_applicationContext.getBean("config.Socket", Socket.class)) {

            System.out.println(TcpUtil.receiveStringViaLength(socket).strip());
        }
        catch (IOException ex) {
            System.err.printf("Error occurred:%s%n", ex.getMessage());
        }
    }

    private void printMenu()
    {
        System.out.println("1.Generate");
        System.out.println("2.Config");
        System.out.println("3.Periodic Message");
        System.out.println("4.Quit");
        System.out.print("Option:");
    }

    private int getOption()
    {
        while (true) {
            try {
                return Integer.parseInt(m_stdin.nextLine());
            }
            catch (NumberFormatException ignore) {
                System.err.println("Invalid value!...");
                printMenu();
            }
        }
    }

    private void generateCallback()
    {
        try {
            System.out.print("Input count:");
            int count = Integer.parseInt(m_stdin.nextLine());

            System.out.print("Input min:");
            int min = Integer.parseInt(m_stdin.nextLine());

            System.out.print("Input bound:");
            int bound = Integer.parseInt(m_stdin.nextLine());

            doSendAndGetMessage(count, min, bound);
        }
        catch (NumberFormatException ignore) {
            System.err.println("Invalid values!...");
        }
    }

    private void configCallback()
    {
        doGetConfig();
    }

    private void periodicSenderCallback(int id)
    {
        UdpUtil.sendString(m_periodicHost, m_periodicPort, String.format("Ok from %d", id));
    }

    private void periodicSenderMenuCallback()
    {
        if (m_periodicSender++ <= 10)
            m_scheduledExecutorService.scheduleAtFixedRate(() -> periodicSenderCallback(m_periodicSender - 1), 0, 1000, TimeUnit.MILLISECONDS);
        else
            System.out.println("Periodic message limit full!...");
    }

    private void quitCallback()
    {
        System.exit(SpringApplication.exit(Application.context, () -> 0));
    }

    private void doOption(int option)
    {
        switch (option) {
            case 1 -> generateCallback();
            case 2 -> configCallback();
            case 3 -> periodicSenderMenuCallback();
            case 4 -> quitCallback();
            default -> System.out.println("Invalid option!...");
        }
    }

    public Client(ApplicationContext applicationContext, ScheduledExecutorService scheduledExecutorService, Scanner stdin)
    {
        m_applicationContext = applicationContext;
        m_scheduledExecutorService = scheduledExecutorService;
        m_stdin = stdin;
    }

    public void run() throws IOException
    {
        while (true) {
            printMenu();
            doOption(getOption());
        }
    }
}
