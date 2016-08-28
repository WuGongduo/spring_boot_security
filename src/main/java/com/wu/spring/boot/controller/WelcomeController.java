package com.wu.spring.boot.controller;


import com.wu.spring.boot.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Optional;

@Controller
public class WelcomeController {
    public static final Logger LOGGER = LoggerFactory.getLogger(WelcomeController.class);
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", "hello world");
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(Map<String, Object> model, @RequestParam Optional<String> error) {
        LOGGER.debug("Getting login page, error={}", error);
        model.put("error", error);
        return "login";
    }

    @RequestMapping("/users")
    public String getUsersPage(Map<String, Object> model) {
        LOGGER.debug("Getting users page");
        model.put("users", userRepository.findAll());
        return "users";
    }
}
