package com.example.MaryCatqapi.mapper.ChurchAddressMapper;

import com.example.MaryCatqapi.dto.ChurchAddressDTO.ChurchAddressPostDTO;
import com.example.MaryCatqapi.entity.ChurchAddress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChurchAddressPostMapper {

    ChurchAddressPostMapper INSTANCE = Mappers.getMapper(ChurchAddressPostMapper.class);

    @Mapping(target = "addressesNumber", source= "addressesNumber")
    ChurchAddress toModel(ChurchAddressPostDTO churchAddressPostDTO);

    @Mapping(target = "addressesNumber", source = "addressesNumber")
    ChurchAddressPostDTO toDto(ChurchAddress churchAddress);

}
