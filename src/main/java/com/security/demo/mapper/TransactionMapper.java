package com.security.demo.mapper;

import com.security.demo.dto.TransactionDTO;
import com.security.demo.entity.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")  // Use "spring" for Spring-based dependency injection
public interface TransactionMapper {

    // Create an instance of the mapper
    //TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    // Entity to DTO mapping
    TransactionDTO toDTO(Transaction transaction);

    // DTO to Entity mapping
    Transaction toEntity(TransactionDTO transactionDTO);
}

