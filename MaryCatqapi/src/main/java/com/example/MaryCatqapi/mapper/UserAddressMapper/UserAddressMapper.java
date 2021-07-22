package com.example.MaryCatqapi.mapper.UserAddressMapper;

import com.example.MaryCatqapi.dto.UserAddress.UserAddressDTO;
import com.example.MaryCatqapi.entity.UserAddress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserAddressMapper {

    UserAddressMapper INSTANCE = Mappers.getMapper(UserAddressMapper.class);

    @Mapping(target = "id", source= "id")
    UserAddress toModel(UserAddressDTO userAddressDTO);

   @Mapping(target = "id", source = "id")
    UserAddressDTO toDto(UserAddress userAddress);
}
