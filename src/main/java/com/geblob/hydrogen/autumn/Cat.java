package com.geblob.hydrogen.autumn;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Cat implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy cat");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init cat");
    }
}
