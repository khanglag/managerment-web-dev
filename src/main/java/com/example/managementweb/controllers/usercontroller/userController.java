package com.example.managementweb.controllers.usercontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class userController {
    @RequestMapping("/signin")
    public String signin() {
        return "View/signin";
    }

    @RequestMapping("/register")
    public String register() {
        return "View/register";
    }
}
