package com.example.managementweb.services.mappers;

import com.example.managementweb.models.dtos.Thanhvien.CreateThanhvienDto;
import com.example.managementweb.models.dtos.Thanhvien.ThanhvienReponsDto;
import com.example.managementweb.models.entities.ThanhvienEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
@Mapper(componentModel = "spring", uses = {ThanhvienMapper.class})
public interface ThanhvienMapper {
    ThanhvienEntity toEntity(CreateThanhvienDto createThanhvienDto);
    ThanhvienReponsDto toReponsDto(ThanhvienEntity thahvienEntity);
}
