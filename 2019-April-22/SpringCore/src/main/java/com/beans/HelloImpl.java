package com.beans;

import com.aspects.annotation.Monitor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component // -- helloImpl
@Component("hello")
@Profile("prod")
@Scope("singleton")
public class HelloImpl implements Hello {

    //@Value("spring core annotations")
    @Value("${message}")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Monitor
    public String sayHello(){
        return "Hello " + message;
    }
}
