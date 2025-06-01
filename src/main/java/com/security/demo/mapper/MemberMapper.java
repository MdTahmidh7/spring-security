package com.security.demo.mapper;

import com.security.demo.dto.MemberDTO;
import com.security.demo.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    MemberDTO toDTO(Member member);

    Member toEntity(MemberDTO memberDTO);
}

