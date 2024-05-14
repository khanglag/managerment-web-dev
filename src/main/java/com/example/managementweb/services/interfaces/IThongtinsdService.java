package com.example.managementweb.services.interfaces;

// import com.example.managementweb.models.dtos.ThongTinSD.ThongtinsudungdangmuonDto;
import com.example.managementweb.models.entities.ThongtinsdEntity;

import java.util.List;

public interface IThongtinsdService {

    // List<ThongtinsudungdangmuonDto> listDangMuon(String id);

    boolean kiemTraMuonHopLe(String maTB);

    ThongtinsdEntity createThongtinsd(ThongtinsdEntity thongtinsdEntity);

}
