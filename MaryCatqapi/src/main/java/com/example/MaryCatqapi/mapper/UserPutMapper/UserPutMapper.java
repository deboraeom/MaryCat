package com.example.MaryCatqapi.mapper.UserPutMapper;

import com.example.MaryCatqapi.dto.UserDTO.UserPostDTO;
import com.example.MaryCatqapi.dto.UserDTO.UserPutDTO;
import com.example.MaryCatqapi.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface UserPutMapper {
    UserPutMapper INSTANCE = Mappers.getMapper(UserPutMapper.class);
    @Mapping(target = "id", source = "id")
    User toModel(UserPutDTO userPutDto);
    @Mapping(target = "id", source = "id")
    UserPutDTO toDto(User User);

}
