package com.example.managementweb.controllers.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.managementweb.models.entities.ThanhvienEntity;
import com.example.managementweb.services.ThanhvienService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {

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
    public String checkLogin(ModelMap models, @RequestParam("mssv") String mssv,
            @RequestParam("password") String password, HttpSession session) {
        System.out.println("================================================================");
        System.out.println("MSSV: " + mssv);
        System.out.println("Password: " + password);
        if (thanhvienService.checkLogin(mssv, password)) {
            session.setAttribute("MaTV", mssv);
            return "View/user";
        }
        models.addAttribute("Error", "Mã thành viên hoặc mật khẩu không chính xác");
        return "redirect:/signin";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("MaTV");
        return "redirect:/signin";
    }

    @PostMapping("/checkRegister")
    public String checkRegister(ModelMap models, @RequestParam("mssv") String mssv, @RequestParam("name") String name,
            @RequestParam("phone") String phone, @RequestParam("email") String email,
            @RequestParam("department") String department, @RequestParam("faculty") String faculty,
            @RequestParam("password") String password, @RequestParam("xnpassword") String xnpassword) {
        System.out.println("================================");
        System.out.println("mssv: " + mssv);
        System.out.println("name: " + name);
        System.out.println("phone: " + phone);
        System.out.println(email);
        System.out.println(department);
        System.out.println(faculty);
        System.out.println(password);
        System.out.println(xnpassword);
        if (!password.equals(xnpassword)) {
            models.addAttribute("Error", "Mật khẩu không khớp");
            return "redirect:/register";
        } else {
            ThanhvienEntity thanhvienEntity = new ThanhvienEntity();
            thanhvienEntity.setId(Integer.parseInt(mssv));
            thanhvienEntity.setHoten(name);
            thanhvienEntity.setKhoa(department);
            thanhvienEntity.setNganh(faculty);
            thanhvienEntity.setSdt(phone);
            thanhvienEntity.setPassword(password);
            thanhvienEntity.setEmail(email);
            thanhvienService.createThanhvien(thanhvienEntity);
            return "redirect:/signin";
        }

    }

}