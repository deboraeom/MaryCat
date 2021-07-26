package com.example.MaryCatqapi.mapper.ChurchAddressMapper;


import com.example.MaryCatqapi.dto.ChurchAddressDTO.ChurchAddressPutDTO;
import com.example.MaryCatqapi.entity.ChurchAddress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChurchAddressPutMapper {

    ChurchAddressPutMapper INSTANCE = Mappers.getMapper(ChurchAddressPutMapper.class);

    @Mapping(target = "addressesNumber", source= "addressesNumber")
    ChurchAddress toModel(ChurchAddressPutDTO churchAddressPutDTO);

    @Mapping(target = "addressesNumber", source = "addressesNumber")
    ChurchAddressPutDTO toDto(ChurchAddress churchAddress);

}
