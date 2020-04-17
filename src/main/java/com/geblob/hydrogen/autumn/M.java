package com.geblob.hydrogen.autumn;

public class M {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("I am finalize");
    }
}
