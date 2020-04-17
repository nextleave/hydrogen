package com.geblob.hydrogen.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {
    private Object proxied;

    public DynamicProxy(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke method");
        Object result = method.invoke(proxied, args);
        System.out.println("after invoke it");
        return result;
    }
}
