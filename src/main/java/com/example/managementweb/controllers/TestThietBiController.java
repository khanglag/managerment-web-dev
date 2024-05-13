package com.example.managementweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.managementweb.models.dtos.ThietBi.ThietbiReponsDto;
import com.example.managementweb.models.entities.ThietbiEntity;
import com.example.managementweb.services.ThietBiService;

import java.util.List;

@Controller
public class TestThietBiController {
    @Autowired
    ThietBiService thietBiService;

    @GetMapping("/testthietbis")
    public String getThietBis(Model model) {
        List<ThietbiReponsDto> list = thietBiService.findAll();
        model.addAttribute("thietbisList", list);
        return "View/testthietbis";
    }

}
