package com.example.managementweb.services.interfaces;

import com.example.managementweb.models.dtos.Thongtinsd.ThongtinsudungdangmuonDto;
import com.example.managementweb.models.dtos.Thongtinsd.ThongtinsudungdangmuonDto;

import java.util.List;

public interface IThongtinsdService {

    List<ThongtinsudungdangmuonDto> listDangMuon(String id);

    boolean kiemTraMuonHopLe(String maTB);
}
