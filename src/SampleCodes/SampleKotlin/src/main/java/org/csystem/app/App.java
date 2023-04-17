package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        var s = new Sample();

        s.setX(10);
        System.out.println(s.getX());
        System.out.println(s.getX() * 2);
    }
}

