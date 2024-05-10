package com.example.managementweb.services;


import com.example.managementweb.models.dtos.ThietBi.CreataThietBiDto;
import com.example.managementweb.models.dtos.ThietBi.ThietbiReponsDto;
import com.example.managementweb.models.entities.ThietbiEntity;
import com.example.managementweb.repositories.ThietbiEntityRepository;
import com.example.managementweb.services.interfaces.IThietBiService;
import com.example.managementweb.services.mappers.ThietBiMapper;
import com.example.managementweb.util.ObjectsValidator;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ThietBiService implements IThietBiService {
    ThietbiEntityRepository repository;
    ThietBiMapper mapper;
    ObjectsValidator<CreataThietBiDto> validator;

    @Override
    public List<ThietbiReponsDto> findAll() {
        List<ThietbiEntity> entities = repository.findAll();
        return entities.stream()
                .map(mapper::toReponsDto)
                .collect(Collectors.toList());
    }

    //Tìm kiếm theo tên thiết bị
    @Override
    public List<ThietbiReponsDto> findByTenTB(String tenTB) {
        List<ThietbiEntity> entities = repository.findByTenTB(tenTB);
        return entities.stream()
                .map(mapper::toReponsDto)
                .collect(Collectors.toList());
    }

    
}
