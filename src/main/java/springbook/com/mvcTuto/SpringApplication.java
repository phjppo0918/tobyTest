package springbook.com.mvcTuto;

import org.springframework.context.support.StaticApplicationContext;
import springbook.com.mvcTuto.model.Hello;

public class SpringApplication {
    public static void main(String[] args) {
        StaticApplicationContext ac = new StaticApplicationContext();
        ac.registerSingleton("hello1", Hello.class);

        Hello hello1 = ac.getBean("hello1", Hello.class);

    }
}
