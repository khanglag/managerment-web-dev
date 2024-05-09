package com.example.managementweb.services;

import com.example.managementweb.models.dtos.Thanhvien.CreateThanhvienDto;
import com.example.managementweb.models.dtos.Thanhvien.ThanhvienReponsDto;
import com.example.managementweb.models.entities.ThanhvienEntity;
import com.example.managementweb.repositories.ThanhvienEntityRepository;
import com.example.managementweb.services.interfaces.IThanhvienService;
import com.example.managementweb.services.mappers.ThanhvienMapper;
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
public class ThanhvienService implements IThanhvienService {
    ThanhvienEntityRepository ThanhvienEntityRepository;
    ThanhvienMapper thanhvienMapper;
    ObjectsValidator<CreateThanhvienDto> ThanhvienValidateor;
    private final ThanhvienEntityRepository thanhvienEntityRepository;

    @Override
    public List<ThanhvienReponsDto> findAll() {
        List<ThanhvienEntity> thanhvienEntityList = ThanhvienEntityRepository.findAll();
        return thanhvienEntityList.stream()
                .map(thanhvienMapper::toReponsDto)
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return thanhvienEntityRepository.count();
    }
}
