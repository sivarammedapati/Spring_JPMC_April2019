package com.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"test"})
public class HelloMockImpl implements Hello {

    public String sayHello() {
        return "Hello Mock Spring";
    }
}
