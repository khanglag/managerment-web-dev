package com.example.managementweb.controllers.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.managementweb.services.ThanhvienService;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PostMapping;

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

    @RequestMapping("/forgotpassword")
    public String forgotpassword() {
        return "View/forgotpassword";
    }

    @PostMapping("/checkLogin")
    public String checkLogin(@RequestParam("mssv") String mssv,
            @RequestParam("password") String password, Model model) {
        System.out.println("================================================================");
        System.out.println("MSSV: " + mssv);
        System.out.println("Password: " + password);
        if (thanhvienService.checkLogin(mssv, password))
            return "View/user";
        model.addAttribute("errorMessage", "Email hoặc mật khẩu không đúng. Vui lòng thử lại.");
        return "redirect:/signin";
    }

    @GetMapping("/logout")
    public String logout() {
        return "View/signin";
    }
}