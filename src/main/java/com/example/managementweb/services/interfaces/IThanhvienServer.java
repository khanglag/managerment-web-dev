package com.example.managementweb.services.interfaces;

import com.example.managementweb.models.dtos.Thanhvien.ThanhvienReponsDto;

import java.util.List;

public interface IThanhvienServer {

    List<ThanhvienReponsDto> findAll();

    long count();
}
