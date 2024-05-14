package com.example.managementweb.services;

// import com.example.managementweb.models.dtos.ThongTinSD.ThongtinsudungdangmuonDto;
import org.springframework.stereotype.Service;

import com.example.managementweb.models.dtos.Xuly.XuLyReponsDtos;
import com.example.managementweb.models.entities.ThanhvienEntity;
import com.example.managementweb.models.entities.XulyEntity;
import com.example.managementweb.repositories.ThanhvienEntityRepository;
import com.example.managementweb.repositories.XulyEntityRepository;
import com.example.managementweb.services.interfaces.IXuLyService;
import com.example.managementweb.services.mappers.XuLyMapper;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class XuLyService implements IXuLyService {

    XulyEntityRepository repository;
    XuLyMapper mapper;
    ThanhvienEntityRepository tvrepository;

    @Override
    public List<XuLyReponsDtos> findByPerson(String id) {
        Optional<ThanhvienEntity> thanhvienEntity = tvrepository.findByid(id);
        return thanhvienEntity.map(maTV -> {
            List<XulyEntity> xulyEntity = thanhvienEntity.get().getXulies().stream().toList();
            return xulyEntity.stream().map(mapper::toDto).collect(Collectors.toList());
        }).orElse(new ArrayList<>());
    }
}
