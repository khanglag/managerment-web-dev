package com.example.managementweb.controllers.usercontroller;

import java.util.List;

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
        List<XuLyReponsDtos> penalties = xulyService.findByPerson(mssv);
        // System.out.println("=============================================");
        // System.out.println(penalties.get(0).get());
        // System.out.println(penalties.get(0).get());
        // System.out.println(penalties.get(0).getId());
        // System.out.println(penalties.get(0).getId());
        // System.out.println(penalties.get(0).getId());
        // System.out.println(penalties.get(0).getId());

        models.addAttribute("penalties", penalties);
        return "View/penalties";
    }

}
