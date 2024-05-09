package com.example.managementweb.services.interfaces;

import com.example.managementweb.models.dtos.Thanhvien.ThanhvienReponsDto;
import java.util.Optional;
import java.util.List;

public interface IThanhvienService {

    List<ThanhvienReponsDto> findAll();

    long count();

    Optional<ThanhvienReponsDto> findByID(String id);

    boolean checkLogin(String id, String password);
}
