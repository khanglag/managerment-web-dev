package com.example.managementweb.services.interfaces;


import com.example.managementweb.models.dtos.ThongTinSD.ThongtinsudungdangmuonDto;

import java.time.LocalDateTime;
import java.util.List;

public interface IThongtinsdService {

    List<ThongtinsudungdangmuonDto> listDangMuon(String id);

    boolean kiemTraTBMuonHopLe(String maTB, LocalDateTime time);

    boolean kiemtraThanhVienHopLe(int maTV);

    String kiemTraDatChoHopLe(int maTV, String maTB, LocalDateTime time);

}
