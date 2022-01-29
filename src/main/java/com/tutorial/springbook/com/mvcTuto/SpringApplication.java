package com.tutorial.springbook.com.mvcTuto;

import com.tutorial.springbook.com.mvcTuto.model.Hello;
import org.springframework.context.support.StaticApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
        StaticApplicationContext ac = new StaticApplicationContext();
        ac.registerSingleton("hello1", Hello.class);

        Hello hello1 = ac.getBean("hello1", Hello.class);

    }
}
