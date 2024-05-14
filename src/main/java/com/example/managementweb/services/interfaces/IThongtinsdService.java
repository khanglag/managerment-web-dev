package com.example.managementweb.services.interfaces;

import com.example.managementweb.models.dtos.ThongTinSD.ThongtinsudungdangmuonDto;
import com.example.managementweb.models.entities.ThongtinsdEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface IThongtinsdService {

    List<ThongtinsudungdangmuonDto> listDangMuon(String id);

    boolean kiemTraTBMuonHopLe(String maTB, LocalDateTime time);

    boolean kiemtraThanhVienHopLe(int maTV);

    String kiemTraDatChoHopLe(int maTV, String maTB, LocalDateTime time);

    ThongtinsdEntity createThongtinsd(ThongtinsdEntity thongtinsdEntity);
}
