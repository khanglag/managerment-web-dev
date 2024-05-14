package com.example.managementweb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.managementweb.models.entities.ThietbiEntity;
import com.example.managementweb.repositories.ThietbiEntityRepository; 

@RestController
public class ThietbiController {

    @Autowired
    private ThietbiEntityRepository thietbi;

    @GetMapping("/api/thietbi")
    public List<ThietbiEntity> getAllThietbi() {
        return thietbi.findAll();
    }
}