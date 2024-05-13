package com.example.managementweb.controllers.usercontroller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.managementweb.models.dtos.Xuly.XuLyReponsDtos;

import jakarta.servlet.http.HttpSession;

@Controller
public class DeviceController {
    @RequestMapping("/borrowdevice")
    public String penalties(ModelMap models, HttpSession session) {

        return "View/borrowDevice";
    }
}
