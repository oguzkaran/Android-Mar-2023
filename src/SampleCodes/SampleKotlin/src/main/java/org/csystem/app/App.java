package org.csystem.app;

class App {
    public static void main(String[] args)
    {

    }
}


class  NumberUtil {
    public static int sumDigits(int a)
    {
        int sum = 0;

        while (a != 0) {
            sum += a % 10;
            a /= 10;
        }

        return Math.abs(sum);
    }
}