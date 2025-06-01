package com.security.demo.converter;

import com.security.demo.enam.TransactionMedium;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TransactionMediumConverter implements AttributeConverter<TransactionMedium, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TransactionMedium attribute) {
        return attribute != null ? attribute.getId() : null;
    }

    @Override
    public TransactionMedium convertToEntityAttribute(Integer dbData) {
        return dbData != null ? TransactionMedium.fromId(dbData) : null;
    }
}
