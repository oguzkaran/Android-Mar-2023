package org.csystem.app;

import java.util.Scanner;

class App {
    public static void main(String[] args)
    {
        var kb = new Scanner(System.in);
        int value;
        
        do {
            value = kb.nextInt();
            System.out.printf("value ?= %d%n", value);
        } while (value != 0);
    }
}

