package com.geblob.hydrogen.autumn;

public class DisOrder {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            Thread threadOne = new Thread(new Runnable() {
                public void run() {
                    a = 1;
                    x = b;
                }
            });
            Thread threadTwo = new Thread(new Runnable() {
                public void run() {
                    b = 1;
                    y = a;
                }
            });
            threadOne.start();
            threadTwo.start();
            threadOne.join();
            threadTwo.join();
            String result = i + "th (" + x + y + ")";
            if (x == 0 && y == 0) {
                System.err.println(result);
                break;
            }
        }
    }
}
