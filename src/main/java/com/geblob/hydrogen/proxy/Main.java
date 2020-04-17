package com.geblob.hydrogen.proxy;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(2);
        rectangle.setWidth(3);
        rectangle.getSize();
        Sizable proxy = (Sizable) Proxy.newProxyInstance(rectangle.getClass().getClassLoader(), new Class[]{Sizable.class}, new DynamicProxy(rectangle));
        System.out.println(proxy.getSize());
    }
}
