package com.example.managementweb.services.mappers;

import com.example.managementweb.models.dtos.ThongTinSD.ReservationsDto;
import com.example.managementweb.models.dtos.ThongTinSD.ThongtinsdReponsDto;
import com.example.managementweb.models.entities.ThongtinsdEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = { ThongtinsdMapper.class })
public interface ThongtinsdMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ReservationsDto toReponsDTO(ReservationsDto reservationsDto);

    ThongtinsdEntity toEntity(ThongtinsdReponsDto thongtinsdReponsDto);

}
