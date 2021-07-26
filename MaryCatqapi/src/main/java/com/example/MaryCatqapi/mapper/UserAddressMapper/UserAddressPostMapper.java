package com.example.MaryCatqapi.mapper.UserAddressMapper;

import com.example.MaryCatqapi.dto.UserAddress.UserAddressPostDTO;
import com.example.MaryCatqapi.entity.UserAddress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface UserAddressPostMapper {

        UserAddressPostMapper INSTANCE = Mappers.getMapper(UserAddressPostMapper.class);

        @Mapping(target = "addressesNumber", source= "addressesNumber")
        UserAddress toModel(UserAddressPostDTO userAddressPostDTO);

        @Mapping(target = "addressesNumber", source = "addressesNumber")
        UserAddressPostDTO toDto(UserAddress userAddress);

}
