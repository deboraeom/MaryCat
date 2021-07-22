package com.example.MaryCatqapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.MaryCatqapi.dto.ChurchDTO;
import com.example.MaryCatqapi.entity.Church;

@Mapper
public interface ChurchMapper {

    ChurchMapper INSTANCE = Mappers.getMapper(ChurchMapper.class);
    @Mapping(target = "id", source = "id")
    Church toModel(ChurchDTO churchDto);
    @Mapping(target = "id", source = "id")
    ChurchDTO toDto(Church church);

}



