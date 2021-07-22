package com.example.MaryCatqapi.mapper;

import com.example.MaryCatqapi.dto.UserDTO;
import com.example.MaryCatqapi.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    @Mapping(target = "id", source = "id")
    User toModel(UserDTO UserDto);
    @Mapping(target = "id", source = "id")
    UserDTO toDto(User User);
}

