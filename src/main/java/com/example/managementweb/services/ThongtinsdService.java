
package com.example.managementweb.services;

import com.example.managementweb.models.dtos.ThongTinSD.ThongtinsdReponsDto;
import com.example.managementweb.models.dtos.Thongtinsd.ThongtinsudungdangmuonDto;
import com.example.managementweb.repositories.ThongtinsdEntityRepository;
import com.example.managementweb.services.interfaces.IThongtinsdService;
import com.example.managementweb.services.mappers.ThongtinsdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThongtinsdService implements IThongtinsdService {
    @Autowired
    private ThongtinsdEntityRepository thongtinsdEntityRepository;
    @Autowired
    private ThongtinsdMapper thongtinsdMapper;

    @Override
    public List<ThongtinsudungdangmuonDto> listDangMuon(String id) {
        return thongtinsdEntityRepository.findThongtinsudungdangmuonDtoByMaTVId(id);
    }

    @Override
    public boolean kiemTraMuonHopLe(String maTB) {
        List<com.example.managementweb.models.dtos.ThongTinSD.ThongtinsdReponsDto> listdtos = thongtinsdEntityRepository.listTB(maTB)
                .stream().map(thongtinsdMapper::toReponsDTO).collect(Collectors.toList());
        com.example.managementweb.models.dtos.ThongTinSD.ThongtinsdReponsDto dto = listdtos.get(listdtos.size() - 1);
        System.out.println(dto.toString());
        if ((dto.getTgtra() != null && dto.getTgtra().isBefore(LocalDateTime.now().minusDays(1))) &&
                (dto.getTgdatcho() == null))
            return true;
        if ((dto.getTgtra() != null && dto.getTgtra().isBefore(LocalDateTime.now().minusDays(1))) &&
                (dto.getTgdatcho().isBefore(LocalDateTime.now().minusDays(1))))
            return true;
        return false;
    }
}
