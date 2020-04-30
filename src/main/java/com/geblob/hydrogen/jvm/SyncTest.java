package com.geblob.hydrogen.jvm;

public class SyncTest {
    private static volatile int i;

    public static void main(String[] args) {
        for (int j = 0; j < 100000; j++) {
            m();
            n();
        }
    }

    private static synchronized void m() {

    }

    private static void n() {
        i = 1;
    }
}
