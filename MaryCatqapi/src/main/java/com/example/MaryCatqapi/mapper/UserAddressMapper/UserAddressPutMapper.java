package com.example.MaryCatqapi.mapper.UserAddressMapper;

import com.example.MaryCatqapi.dto.UserAddress.UserAddressPostDTO;
import com.example.MaryCatqapi.dto.UserAddress.UserAddressPutDTO;
import com.example.MaryCatqapi.entity.UserAddress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserAddressPutMapper {
    UserAddressPutMapper INSTANCE = Mappers.getMapper(UserAddressPutMapper.class);

    @Mapping(target = "addressesNumber", source= "addressesNumber")
    UserAddress toModel(UserAddressPutDTO userAddressPutDTO);

    @Mapping(target = "addressesNumber", source = "addressesNumber")
    UserAddressPutDTO toDto(UserAddress userAddress);
}
