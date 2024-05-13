package com.example.managementweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.managementweb.models.dtos.ThietBi.ThietbiReponsDto;
import com.example.managementweb.models.entities.ThietbiEntity;
import com.example.managementweb.services.ThietBiService;

import java.util.List;
import java.util.Optional;

@Controller
public class TestThietBiController {
    @Autowired
    ThietBiService thietBiService;

    @GetMapping("/testthietbis")
    public String getTThietBis(Model model) {
        List<ThietbiReponsDto> list = thietBiService.findAll();
        model.addAttribute("thietbisList", list);
        return "View/testthietbis";
    }

    @GetMapping("/testthietbis/{id}")
    @ResponseBody
    public String getThietBiDetail(@PathVariable("id") String id, Model model) {
        Optional<ThietbiReponsDto> thietbi = thietBiService.findByID(id);
        model.addAttribute("thietbi", thietbi.get());
        return "View/thietbiDetail"; // Trả về view chi tiết của thiết bị
    }

    // @GetMapping("/thietbis/{id}")
    // @ResponseBody
    // public ThietbiReponsDto getThietBiDetail(@PathVariable("id") String id) {
    // Optional<ThietbiReponsDto> thietbi = thietBiService.findByID(id);
    // ThietbiReponsDto thietbiDetail = thietbi.get();
    // return thietbiDetail;
    // }
    @GetMapping("/thietbis")
    public String getThietBis(Model model) {
        List<ThietbiReponsDto> list = thietBiService.findAll();
        model.addAttribute("thietbisList", list);
        return "View/thietbis";
    }

    @GetMapping("/thietbis/{id}")
    public String getThietBiDetailn(@PathVariable("id") String id, Model model) {
        Optional<ThietbiReponsDto> thietbi = thietBiService.findByID(id);
        model.addAttribute("thietbi", thietbi.get());
        return "View/thietbiDetail"; // Trả về view chi tiết của thiết bị
    }

    // @GetMapping("/thietbi/{id}")
    // public String showThietBiDetail(@PathVariable String id, Model model) {

    // Optional<ThietbiReponsDto> thietbi = thietBiService.findByID(id);
    // model.addAttribute("thietbi", thietbi.get());
    // return "View/thietbi_detail_model"; // Tên của file Thymeleaf template
    // }

    // @GetMapping("/thietbis/{id}")
    // @ResponseBody
    // public ThietbiReponsDto getThietBiDetail(@PathVariable("id") String id) {
    // Optional<ThietbiReponsDto> thietbi = thietBiService.findByID(id);

    // return thietbi.get();
    // }
}
