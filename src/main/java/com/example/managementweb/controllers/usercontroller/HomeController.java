package com.example.managementweb.controllers.usercontroller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.managementweb.models.dtos.Thanhvien.ThanhvienReponsDto;
import com.example.managementweb.models.dtos.ThietBi.ThietbiReponsDto;
import com.example.managementweb.models.entities.ThanhvienEntity;
import com.example.managementweb.services.ThanhvienService;
import com.example.managementweb.services.ThietBiService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {

    @Autowired
    private ThanhvienService thanhvienService;

    @Autowired
    private ThietBiService thietBiService;

    @RequestMapping("/")
    public String home() {
        return "redirect:/signin";
    }

    @RequestMapping("/signin")
    public String signin() {
        return "View/signin";
    }

    @RequestMapping("/register")
    public String register() {
        return "View/register";
    }

    @RequestMapping("/profile")
    public String showProfile(ModelMap models, HttpSession session) {
        String mssv = (String) session.getAttribute("mssv");
        if (mssv == null) {
            return "redirect:/signin";
        }
        Optional<ThanhvienReponsDto> thanhVien = thanhvienService.findByID(mssv);
        if (thanhVien.isPresent()) {
            ThanhvienReponsDto thanhVienDto = thanhVien.get();
            session.setAttribute("MaTV", thanhVienDto.getId());
            session.setAttribute("TenTV", thanhVienDto.getHoten());
            session.setAttribute("Khoa", thanhVienDto.getKhoa());
            session.setAttribute("Nganh", thanhVienDto.getNganh());
            session.setAttribute("SDT", thanhVienDto.getSdt());
            session.setAttribute("Email", thanhVienDto.getEmail());
        }
        return "View/profile";
    }

    @RequestMapping("/changePassword")
    public String changPassword() {
        return "View/changePassword";
    }

    @RequestMapping("/forgotpassword")
    public String forgotpassword() {
        return "View/forgotpassword";
    }

    @PostMapping("/index")
    public String checkLogin(ModelMap models, @RequestParam("mssv") String mssv,
            @RequestParam("password") String password, HttpSession session) {
        System.out.println("================================================================");
        System.out.println("MSSV: " + mssv);
        System.out.println("Password: " + password);
        if (thanhvienService.checkLogin(mssv, password)) {
            session.setAttribute("mssv", mssv);
            session.setAttribute("password", password);
            models.addAttribute("mssv", password);
            models.addAttribute("password", password);
            Optional<ThanhvienReponsDto> thanhVien = thanhvienService.findByID(mssv);
            if (thanhVien.isPresent()) {
                ThanhvienReponsDto thanhVienDto = thanhVien.get();
                session.setAttribute("TenTV", thanhVienDto.getHoten());
            }
            return "index";
        }
        return "redirect:/signin?passwordwrong";
    }

    @PostMapping("/changePassword")

    public String changePassword(@RequestParam String oldPass, @RequestParam String newPass,
            @RequestParam String reNewPass, HttpSession session, RedirectAttributes redirectAttributes) {
        String mssv = (String) session.getAttribute("mssv");
        String password = (String) session.getAttribute("password");
        if (!oldPass.equals(password)) {
            return "redirect:/changePassword?oldPassWrong";
        }
        if (!newPass.equals(reNewPass)) {
            return "redirect:/changePassword?newPassIsDifferent";
        }
        thanhvienService.changePassword(mssv, newPass);

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
        if (thanhvienService.findByID(mssv).isPresent()) {
            return "redirect:/register?mssvexist";
        } else if (thanhvienService.checkEmailExists(email)) {
            return "redirect:/register?emailexist";
        } else if (!password.equals(xnpassword)) {
            return "redirect:/register?matkhaukhongkhop";
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

    // reservation
    @GetMapping("/reservation")
    public String getThietBis(Model model) {
        List<ThietbiReponsDto> list = thietBiService.findAll();
        model.addAttribute("thietbisList", list);
        return "View/reservation";
    }

    @GetMapping("/reservation/{id}")
    public String getThietBiDetailn(@PathVariable("id") String id, Model model) {
        Optional<ThietbiReponsDto> thietbi = thietBiService.findByID(id);
        model.addAttribute("thietbi", thietbi.get());
        return "View/thietbiDetail"; // Trả về view chi tiết của thiết bị
    }

    @PostMapping("/reservationDevice")
    public String reservationDevice(HttpSession session, @RequestParam("thietbiId") String id,
            @RequestParam("ngayGioDat") String date) {
        System.out.println("================================================");
        System.out.println(id);
        System.out.println(date);
        String mssv = (String) session.getAttribute("mssv");
        System.out.println(mssv);
        return "View/reservation";
    }

}