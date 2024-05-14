package com.example.managementweb.controllers.usercontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.managementweb.models.dtos.ThongTinSD.ThongtinsudungdangmuonDto;
import com.example.managementweb.models.dtos.Xuly.XuLyReponsDtos;
import com.example.managementweb.services.ThongtinsdService;
import com.example.managementweb.services.XuLyService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DeviceController {
    @Autowired
    private ThongtinsdService ttsdService;

    @RequestMapping("/borrowdevice")
    public String penalties(ModelMap models, HttpSession session) {
        String mssv = (String) session.getAttribute("mssv");
        List<ThongtinsudungdangmuonDto> borrowDevice = ttsdService.listDangMuon(mssv);
        models.addAttribute("borrowDevice", borrowDevice);
        return "View/borrowDevice";
    }
}
