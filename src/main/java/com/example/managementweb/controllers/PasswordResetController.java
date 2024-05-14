package com.example.managementweb.controllers;

import java.security.SecureRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.managementweb.services.EmailService;
import com.example.managementweb.services.ThanhvienService;

@Controller
public class PasswordResetController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private ThanhvienService thanhvienService;

    @PostMapping("/reset-password")
    @ResponseBody
    public String resetPassword(@RequestParam String email) {
        if (!thanhvienService.checkEmailExists(email))
            return "Email không tồn tại trong hệ thống.";
        String newPassword = generateNewPassword();
        thanhvienService.changePasswordByEmail(email, newPassword);

        emailService.sendSimpleMessage(email, "Đặt lại mật khẩu", "Mật khẩu mới của bạn là: " + newPassword);

        return "Một email chứa mật khẩu mới đã được gửi đến địa chỉ email của bạn.";
    }

    private static String generateNewPassword() {
        int length = 8;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            sb.append(characters.charAt(randomIndex));
        }
        return sb.toString();
    }

    public static void main(final String[] args) {
        System.out.println(generateNewPassword());
    }
}