package com.security.demo.mapper;

import com.security.demo.dto.UserDTO;
import com.security.demo.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "email", target = "email")
    Users userDTOToUser(UserDTO userDTO);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "email", target = "email")
    UserDTO userToUserDTO(Users user);
}

