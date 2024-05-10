package com.example.managementweb.services.interfaces;

import com.example.managementweb.models.dtos.Thanhvien.CreateThanhvienDto;
import com.example.managementweb.models.dtos.Thanhvien.ThanhvienReponsDto;
import com.example.managementweb.models.entities.ThanhvienEntity;

import java.util.Optional;
import java.util.List;

public interface IThanhvienService {

    List<ThanhvienReponsDto> findAll();

    long count();


    Optional<ThanhvienReponsDto> findByID(String id);

    boolean checkLogin(String id, String password);

    boolean checkEmailExists(String email);

    ThanhvienEntity createThanhvien(ThanhvienEntity thanhvien);
}
