package com.geblob.hydrogen.spi;

public class YetAnotherSpiFacadeImpl implements SpiFacade {

    @Override
    public String sayHello(String name) {
        return "goodbye, " + name;
    }
}
