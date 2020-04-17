package com.geblob.hydrogen.test;

import com.geblob.hydrogen.autumn.M;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class SoftReferenceTest {
    public static void main(String[] args) {
        SoftReference<byte[]> m = new SoftReference<byte[]>(new byte[1024 * 1024 * 10]);
        WeakReference<M> n = new WeakReference<M>(new M());
        System.out.println(n.get());
        System.gc();
        System.out.println(n.get());

    }
}
