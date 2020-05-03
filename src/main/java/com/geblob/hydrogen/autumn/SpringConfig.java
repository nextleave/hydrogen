package com.geblob.hydrogen.autumn;

import com.geblob.hydrogen.pojo.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@Import({Person.class, MyImportSelector.class, MyDefinitionRegister.class})
@ComponentScan({"com.geblob.hydrogen.autumn"})
public class SpringConfig {
    @Conditional(WindowsCondition.class)
    @Bean("bill")
    public Person person01() {
        return new Person("bill gates", 62);
    }

    @Conditional(LinuxCondition.class)
    @Bean("linus")
    public Person person02() {
        return new Person("linus", 48);
    }

    @Bean("color")
    public ColorFactoryBean getColor() {
        return new ColorFactoryBean();
    }

    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean(value = "car", initMethod = "initCar", destroyMethod = "destroyCar")
    public Car getCar() {
        return new Car();
    }
}
