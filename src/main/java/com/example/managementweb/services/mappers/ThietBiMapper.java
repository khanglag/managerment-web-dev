package com.example.managementweb.services.mappers;

import com.example.managementweb.models.dtos.ThietBi.CreataThietBiDto;
import com.example.managementweb.models.dtos.ThietBi.ThietbiReponsDto;
import com.example.managementweb.models.entities.ThietbiEntity;

import org.mapstruct.Mapper;
@Mapper(componentModel = "spring", uses = {ThietBiMapper.class})
public interface ThietBiMapper {
    ThietbiEntity toEntity(CreataThietBiDto creataThietBiDto);
    ThietbiReponsDto toReponsDto(ThietbiEntity thietbiEntity);
}
