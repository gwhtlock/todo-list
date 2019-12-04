package org.fedex.controller;

import lombok.extern.slf4j.Slf4j;
import org.fedex.service.DemoService;
import org.fedex.service.DemoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@Controller
public class DemoController {


    //== fields ==
    private final  DemoService demo;


    //== constructors ==
    @Autowired
    public DemoController(DemoService demo) {
        this.demo = demo;
    }


    //== request methods ==

    //http:localhost:8080/todo-list/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }


    //http://localhost:8080/todo-list/welcome
    //http://localhost:8080/todo-list/welcome?user=Aaron
    @GetMapping("welcome")
    public String welcome(@RequestParam String user,@RequestParam int age, Model model){

        model.addAttribute("statement", demo.getHelloMessage(user));
        model.addAttribute("age",age);
        model.addAttribute("user",user);
        log.info("model= {}", model);

        //prefix + name + suffix
        ///WEB-INF/welcome.jsp
        return "welcome";
    }


    // == model attributes
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("welcomeMessage() called");
        return demo.getWelcomeMessage();

    }
}
