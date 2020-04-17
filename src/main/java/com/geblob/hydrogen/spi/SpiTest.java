package com.geblob.hydrogen.spi;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ServiceLoader;

@Component
public class SpiTest {
    @PostConstruct
    public  void test() throws IOException {
        System.out.println(System.getProperty("user.dir"));
        System.out.println(new java.io.File(".").getCanonicalPath());
        ServiceLoader<SpiFacade> spiFacadeServiceLoader = ServiceLoader.load(SpiFacade.class);
        for (SpiFacade spiFacade : spiFacadeServiceLoader) {
            spiFacade.sayHello("lancepro");
        }
    }
}
