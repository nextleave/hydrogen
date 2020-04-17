package com.geblob.hydrogen.spi;

public class SpiFacadeImpl implements SpiFacade {
    @Override
    public String sayHello(String name) {
        return "hello, " + name;
    }
}
