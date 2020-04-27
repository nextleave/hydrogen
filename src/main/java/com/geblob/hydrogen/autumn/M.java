package com.geblob.hydrogen.autumn;

public class M {
    private Long a;
    private  char b;
    private  byte d;
    private  int c;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("I am finalize");
    }
}
