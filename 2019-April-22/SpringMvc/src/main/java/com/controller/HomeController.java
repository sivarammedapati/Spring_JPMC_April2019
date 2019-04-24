package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {

    // /home
    @RequestMapping
    public String handleRequest(){

        System.out.println("HomeController.handleRequest");
        return "index";
    }

    // /home/hello?msg=abc
    @RequestMapping("/hello")
    public ModelAndView hello(@RequestParam(name="msg") String message){

        System.out.println("HomeController.hello: " + message);
        String formattedMsg = "Hello " + message.toUpperCase();
        return  new ModelAndView("index", "fMsg", formattedMsg);
    }

}
