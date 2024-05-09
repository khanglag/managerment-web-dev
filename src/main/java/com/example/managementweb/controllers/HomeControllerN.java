package com.example.managementweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeControllerN {
    @RequestMapping("")
    public String index() {
        return "index";
    }
}
