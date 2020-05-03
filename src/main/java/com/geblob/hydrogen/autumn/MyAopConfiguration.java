package com.geblob.hydrogen.autumn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class MyAopConfiguration {
    @Bean
    MathCalculator calculator() {
        return new MathCalculator();
    }

    @Bean
    LogAspect logAspect() {
        return new LogAspect();
    }
}
