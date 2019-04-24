package com.app;

import com.aspects.annotation.Monitor;
import com.beans.AccountService;
import com.beans.Hello;

import com.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Application {


    private AccountService service;

    @Autowired
    public Application(AccountService accountService){
        this.service = accountService;
        System.out.println("Application.Application");
    }


    @Monitor
    public void printAccountName(){
        System.out.println("Account Name: " + service.getName());
    }

    public static void main(String[] args) {
        //xmlAppConfig();
        annotationAppConfig();
    }

    private  static  void annotationAppConfig(){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("prod");
        context.register(AppConfig.class);
        context.refresh();

        System.out.println("Application Context Loaded");

        Hello hello = context.getBean(Hello.class);
        System.out.println("Type of hello: " + hello.getClass().getName());
        System.out.println("sayHello: " + hello.sayHello());

        //AccountService accountService = context.getBean(AccountService.class);
        //System.out.println("AccountService name: " + accountService.getName());


        Application application = context.getBean(Application.class);
        application.printAccountName();

        context.close();
    }

    private static void xmlAppConfig() {
        //Load the Spring Context

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        context.getEnvironment().setActiveProfiles("test", "windows");
        context.refresh();


        //By Type
        Hello hello = context.getBean(Hello.class);

        //By name(id)
        //Hello hello = (Hello)context.getBean("hello");

        System.out.println("Hello sayHello: " + hello.sayHello());
    }
}
