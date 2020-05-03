package com.geblob.hydrogen.autumn;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {
    @Test
    public void testAop() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyAopConfiguration.class);
        MathCalculator calculator = (MathCalculator) applicationContext.getBean("calculator");
        calculator.div(3, 0);

    }
}
