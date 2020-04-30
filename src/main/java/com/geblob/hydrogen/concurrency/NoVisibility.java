package com.geblob.hydrogen.concurrency;

public class NoVisibility {
    private static boolean ready;
    private static int number;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }).start();
        Thread.sleep(10);
        number = 42;
        ready = true;
    }
}
