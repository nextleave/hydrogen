package com.geblob.hydrogen.test;

import com.geblob.hydrogen.autumn.M;

import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {
    static ThreadLocal<M> mThreadLocal = new ThreadLocal<M>();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(mThreadLocal.get());
        }).start();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mThreadLocal.set(new M());
            mThreadLocal.remove();
        }).start();
    }
}
