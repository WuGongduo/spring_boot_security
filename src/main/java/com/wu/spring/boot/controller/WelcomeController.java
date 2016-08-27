package com.wu.spring.boot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class WelcomeController {

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", "hello world");
        return "welcome";
    }
}
