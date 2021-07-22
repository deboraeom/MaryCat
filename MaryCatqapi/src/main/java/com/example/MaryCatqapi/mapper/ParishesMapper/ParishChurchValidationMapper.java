package com.example.MaryCatqapi.mapper.ParishesMapper;

import com.example.MaryCatqapi.dto.ParishesDTO.ParishDTO;
import com.example.MaryCatqapi.entity.Parish;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParishChurchValidationMapper {

    ParishMapper INSTANCE = Mappers.getMapper(ParishMapper.class);
   @Mapping(target = "name", source = "name")
    Parish toModel(ParishDTO parishDTO);
    @Mapping(target = "name", source = "name")
    ParishDTO toDto(Parish Parish);

}
