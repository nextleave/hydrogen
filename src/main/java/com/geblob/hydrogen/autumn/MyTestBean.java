package com.geblob.hydrogen.autumn;

import lombok.Data;
import lombok.ToString;
import org.openjdk.jol.info.ClassLayout;

import java.io.IOException;

@Data
@ToString
public class MyTestBean {
    private String testStr = "lancepro";
    private volatile int a;

    public static void main(String[] args) throws IOException {
        Object o = new Object();
//        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        System.out.println(ClassLayout.parseInstance(new M()).toPrintable());

        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
        M m = new M();
        m = null;
        System.gc();
//        System.in.read();
    }
}
