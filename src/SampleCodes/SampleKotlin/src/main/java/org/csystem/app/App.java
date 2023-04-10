package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        EXIT:
        for (int i = 5; i < 20; ++i) {
            for (int k = 30; k > 3; --k) {
                System.out.printf("(%d, %d)%n", i, k);

                if ((i + k) % 11 == 0)
                    break EXIT;
            }
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}

