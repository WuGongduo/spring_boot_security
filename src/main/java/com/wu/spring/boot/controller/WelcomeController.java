package com.wu.spring.boot.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Optional;

@Controller
public class WelcomeController {
    public static final Logger LOGGER = LoggerFactory.getLogger(WelcomeController.class);

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", "hello world");
        return "welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(Map<String, Object> model, @RequestParam Optional<String> error) {
        LOGGER.debug("Getting login page, error={}", error);
        model.put("error", error);
        return "login";
    }
}
