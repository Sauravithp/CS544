package com.example.exercise11_1;


import com.example.exercise11_1.domain.Greeting;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exercise111Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext=new ClassPathXmlApplicationContext
                ("springConfig.xml");

        Greeting greetingService=configurableApplicationContext.getBean("greetingService",Greeting.class);
        greetingService.sayHello();
    }

}
