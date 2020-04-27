package com.geblob.hydrogen.lock;

public class TestMonitor {
    public static void main(String[] args) throws InterruptedException {
        synchronized (TestMonitor.class) {
            TestMonitor.class.wait(10);
            System.out.println("haha");
//            TestMonitor.class.notify();
        }
    }
}
