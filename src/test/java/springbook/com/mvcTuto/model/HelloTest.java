package springbook.com.mvcTuto.model;

import org.junit.Test;
import org.springframework.context.support.StaticApplicationContext;

public class HelloTest {
    @Test
    public void hello() {
        StaticApplicationContext ac = new StaticApplicationContext();
        //ac.registerSingleton("hello1", Hello.class);

       // Hello hello1 = ac.getBean("hello1", Hello.class);
        //assertThat(hello1, is(notNullValue()));
    }
}