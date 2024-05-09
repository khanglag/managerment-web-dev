package com.example.managementweb.services.interfaces;

import java.util.List;

import com.example.managementweb.models.dtos.ThietBi.ThietBiDTO;

public interface IThietBiService {
    List<ThietBiDTO> findByName(String TenTB);
}