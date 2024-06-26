package com.example.managementweb.controllers.usercontroller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.managementweb.models.dtos.Xuly.XuLyReponsDtos;
import com.example.managementweb.services.XuLyService;

import jakarta.servlet.http.HttpSession;

@Controller
public class XuLyController {
    @Autowired
    private XuLyService xulyService;

    @RequestMapping("/penalties")
    public String penalties(ModelMap models, HttpSession session) {
        String mssv = (String) session.getAttribute("mssv");

        TimeZone databaseTimeZone = TimeZone.getTimeZone("GMT + 7");
        SimpleDateFormat sdfDisplay = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdfDisplay.setTimeZone(databaseTimeZone);
        List<XuLyReponsDtos> penalties = xulyService.findByPerson(mssv);
        if (penalties.size() == 0) {
            models.addAttribute("penalties", penalties);
            return "View/penalties";
        }
        LocalDateTime Ngayxl = (LocalDateTime) penalties.get(0).getNgayxl();
        String formattedTGVao = sdfDisplay.format(Date.from(Ngayxl.atZone(ZoneId.of("GMT")).toInstant()));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parsedDateTime = LocalDateTime.parse(formattedTGVao, formatter);
        penalties.get(0).setNgayxl(parsedDateTime);
        models.addAttribute("penalties", penalties);

        return "View/penalties";
    }

}
