package com.geblob.hydrogen.autumn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutoWareComponent {
    @Autowired
    private Car car;

    public void printCar() {
        System.out.println("in autowared component " + car);
    }
}
