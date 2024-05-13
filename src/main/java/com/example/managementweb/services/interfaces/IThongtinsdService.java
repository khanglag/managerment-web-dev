package com.example.managementweb.services.interfaces;

import com.example.managementweb.models.dtos.ThongTinSD.ThongtinsudungdangmuonDto;

import java.util.List;

public interface IThongtinsdService {

    List<ThongtinsudungdangmuonDto> listDangMuon(String id);
}
