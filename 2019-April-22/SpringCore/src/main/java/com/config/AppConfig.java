package com.config;

import com.beans.Hello;
import com.beans.HelloImpl;
import com.beans.HelloMockImpl;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan({"com.beans", "com.app", "com.aspects"})
@PropertySource({"classpath:foo.properties"})
@EnableAspectJAutoProxy
//@EnableLoadTimeWeaving
public class AppConfig {

    /*<bean  id="hello" class="com.beans.HelloImpl">
        <property name="message" value="Spring Core"></property>
    </bean>*/

   /* @Bean
    @Profile("prod")
    public Hello hello(){

        HelloImpl hello = new HelloImpl();
        hello.setMessage("Spring Bean Config");
        return hello;
    }

    @Bean
    @Profile("test")
    public Hello mock(){
        Hello hello = new HelloMockImpl();
        return hello;
    }*/
}
