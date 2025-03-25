package com.security.demo.mapper;

import com.security.demo.dto.ItemDTO;
import com.security.demo.dto.UserDTO;
import com.security.demo.entity.Item;
import com.security.demo.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "createdDateTime", target = "createdDateTime")
    @Mapping(source = "endDateTime", target = "endDateTime")
    @Mapping(source = "image", target = "image")
    Item toEntity(ItemDTO itemDTO);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "createdDateTime", target = "createdDateTime")
    @Mapping(source = "endDateTime", target = "endDateTime")
    @Mapping(source = "image", target = "image")
    ItemDTO toDTO(Item item);
}
