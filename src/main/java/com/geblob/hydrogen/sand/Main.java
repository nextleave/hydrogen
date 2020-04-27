package com.geblob.hydrogen.sand;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static AtomicInteger number = new AtomicInteger(1);
    static ReentrantLock reentrantLock = new ReentrantLock(true);

    public static void main(String[] args) {
        System.out.println("testWithFloats\n");
        float a = 0.1f * 100;
        float b = 0.1f * 100;
        float c = 0.1f * 100;

        float d = a + b + c;
        float e = d * 3;
        float f = d * 100000;

        System.out.println("a + b + c = d = " + d / 100);
        System.out.println("e = " + e / 100);
        System.out.println("f = " + f / 100);
        char[] array = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
        System.out.println(array);
        reverseCharArray(array);
        System.out.println(array);
      Integer sss =   Integer.parseInt(new String(new char[]{'0', '3', '3', '1'}));

        List<Thread> threadList = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            threadList.add(new Thread(() -> {
                while (number.get() < 100) {
                    reentrantLock.lock();
                    System.out.println(Thread.currentThread().getName() + ":" + number.getAndIncrement());
                    reentrantLock.unlock();
                }
            }, "t" + i));
        }
        for (Thread thread : threadList) {
            thread.start();
        }
    }


    public static void reverseCharArray(char[] a) {
        char temp;
        for (int i = 0; i < a.length / 2; i++) {
            temp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = temp;
        }
    }


}
