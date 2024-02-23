package org.csystem.app.generator.text.server;

import com.karandev.util.net.TcpUtil;
import com.karandev.util.net.exception.NetworkException;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.stream.Stream;

@Component
public class Client {
    private final ApplicationContext m_applicationContext;

    private final Scanner m_stdin;

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
        System.out.println("3.Quit");
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

    private void quitCallback()
    {
        System.exit(SpringApplication.exit(Application.context, () -> 0));
    }

    private void doOption(int option)
    {
        switch (option) {
            case 1 -> generateCallback();
            case 2 -> configCallback();
            case 3 -> quitCallback();
            default -> System.out.println("Invalid option!...");
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
            printMenu();
            doOption(getOption());
        }
    }
}
