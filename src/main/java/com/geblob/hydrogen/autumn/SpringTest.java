package com.geblob.hydrogen.autumn;

import com.geblob.hydrogen.pojo.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class SpringTest {
    @Test
    public void testSpring() throws InterruptedException {
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("default", "test");
        applicationContext.register(SpringConfig.class);
        applicationContext.refresh();
        Map<String, Person> map = applicationContext.getBeansOfType(Person.class);
        System.out.println(map);
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
//        Object object = applicationContext.getBean("&color");
//        System.out.println(object);
//        object = applicationContext.getBean("color");
//        System.out.println(object);
        Car car =(Car) applicationContext.getBean("car");
        Thread.sleep(1000l);
        AutoWareComponent autoWareComponent = (AutoWareComponent)applicationContext.getBean("autoWareComponent") ;
        autoWareComponent.printCar();
        applicationContext.close();
    }
}
