package com.wu.spring.boot.controller;


import com.wu.spring.boot.domain.Role;
import com.wu.spring.boot.domain.User;
import com.wu.spring.boot.domain.UserCreateForm;
import com.wu.spring.boot.domain.UserCreateFormValidator;
import com.wu.spring.boot.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class WelcomeController {
    public static final Logger LOGGER = LoggerFactory.getLogger(WelcomeController.class);
    @Autowired
    UserRepository userRepository;
    @Autowired
    private  UserCreateFormValidator userCreateFormValidator;


    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", "hello world");
        return "home";
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
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

    @PreAuthorize("hasAuthority('admin')")
    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public ModelAndView getUserCreatePage() {
        LOGGER.debug("Getting user create form");
        return new ModelAndView("user_create", "form", new UserCreateForm());
    }

    @PreAuthorize("hasAuthority('admin')")
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult) {
        LOGGER.debug("Processing user create form={}, bindingResult={}", form, bindingResult);
        if (bindingResult.hasErrors()) {
            // failed validation
            return "user_create";
        }
        try {
            User user = new User();
            user.setName(form.getName());
            user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
            List<Role> roleList =new ArrayList<>();
            roleList.add(new Role(form.getRole()));
            user.setRoleList(roleList);
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate name", e);
            bindingResult.reject("name.exists", "name already exists");
            return "user_create";
        }
        // ok, redirect
        return "redirect:/users";
    }

}
