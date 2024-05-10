package com.example.managementweb.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.managementweb.models.dtos.Xuly.CreateXuLyDto;
import com.example.managementweb.models.dtos.Xuly.XuLyReponsDtos;
import com.example.managementweb.models.entities.XulyEntity;

@Mapper(componentModel = "spring")
public interface XuLyMapper {

    @Mappings({
            @Mapping(target = "ngayxl", source = "ngayxl", dateFormat = "dd-MM-yyyy")
    })
    XuLyReponsDtos toDto(XulyEntity xulyEntity);

    XulyEntity toEntity(CreateXuLyDto createXuLyDto);

    // XuLyReponsDto toResponseDto(XulyEntity xulyEntity);
}
