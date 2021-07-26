package com.example.MaryCatqapi.mapper.UserPutMapper;

import com.example.MaryCatqapi.dto.UserDTO.UserPostDTO;
import com.example.MaryCatqapi.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface UserPostMapper {
    UserPostMapper INSTANCE = Mappers.getMapper(UserPostMapper.class);
    @Mapping(target = "id", source = "id")
    User toModel(UserPostDTO userPostDto);
    @Mapping(target = "id", source = "id")
    UserPostDTO toDto(User User);
}

