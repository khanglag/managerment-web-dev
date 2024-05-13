package com.example.managementweb.services.interfaces;

import com.example.managementweb.models.dtos.Thanhvien.ThanhvienReponsDto;
import com.example.managementweb.models.dtos.ThietBi.ThietbiReponsDto;

import java.util.List;
import java.util.Optional;

public interface IThietBiService {
    List<ThietbiReponsDto> findAll();

    List<ThietbiReponsDto> findByTenTB(String tenTB);

    Optional<ThietbiReponsDto> findByID(String id);

}
