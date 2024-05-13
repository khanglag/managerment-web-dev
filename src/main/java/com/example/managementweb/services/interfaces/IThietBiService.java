package com.example.managementweb.services.interfaces;


import com.example.managementweb.models.dtos.Thanhvien.ThanhvienReponsDto;
import com.example.managementweb.models.dtos.ThietBi.ThietbiReponsDto;

import java.util.List;

public interface IThietBiService {
    List<ThietbiReponsDto> findAll();
    List<ThietbiReponsDto> findByTenTB(String tenTB);
}
