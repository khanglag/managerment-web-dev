package com.example.managementweb.controllers.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.managementweb.services.ThanhvienService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class userController {

    @Autowired
    private ThanhvienService thanhvienService;

    @RequestMapping("/signin")
    public String signin() {
        return "View/signin";
    }

    @RequestMapping("/register")
    public String register() {
        return "View/register";
    }

    @PostMapping("/checkLogin")
    public String checkLogin(@RequestParam("mssv") String mssv,
            @RequestParam("password") String password) {
        System.out.println("================================================================");
        System.out.println("MSSV: " + mssv);
        System.out.println("Password: " + password);
        if (thanhvienService.checkLogin(mssv, password)) {
            return "View/user";
        }
        return "View/signin";
    }

    @GetMapping("/logout")
    public String logout() {
        return "View/signin";
    }
}
