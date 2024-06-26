package com.example.managementweb.services.mappers;

import com.example.managementweb.models.dtos.Thongtinsd.ThongtinsdReponsDto;
import com.example.managementweb.models.entities.ThongtinsdEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = { ThanhvienMapper.class })
public interface ThongtinsdMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    // ReservationsDto toReponsDTO (ReservationsDto reservationsDto);
    ThongtinsdEntity toEntity(ThongtinsdReponsDto thongtinsdReponsDto);

    ThongtinsdReponsDto toReponsDTO(ThongtinsdEntity thongtinsdEntity);

}
