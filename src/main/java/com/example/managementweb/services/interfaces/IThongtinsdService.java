package com.example.managementweb.services.interfaces;

import com.example.managementweb.models.dtos.Thongtinsd.ThongtinsudungdangmuonDto;

import java.time.LocalDateTime;
import java.util.List;

public interface IThongtinsdService {

    List<ThongtinsudungdangmuonDto> listDangMuon(String id);

    List<ThongtinsudungdangmuonDto> listDaMuon(String id);

    boolean kiemTraTBMuonHopLe(String maTB, LocalDateTime time);

    boolean kiemtraThanhVienHopLe(int maTV);

    String kiemTraDatChoHopLe(int maTV, String maTB, LocalDateTime time);

}
