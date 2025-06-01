package com.security.demo.entity;

import com.security.demo.converter.TransactionMediumConverter;
import com.security.demo.converter.TransactionTypeConverter;
import com.security.demo.converter.YearMonthAttributeConverter;
import com.security.demo.enam.TransactionMedium;
import com.security.demo.enam.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.YearMonth;

@Entity
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Double depositAmount;

    private Double withdrawAmount;

    @Enumerated(EnumType.ORDINAL)
    @Convert(converter = TransactionTypeConverter.class)
    private TransactionType transactionType;

    private LocalDate transactionDate;

    private int receiverId;

    private int senderId;

    @Enumerated(EnumType.ORDINAL)
    @Convert(converter = TransactionMediumConverter.class)
    private TransactionMedium transactionMedium;

    //Max 255 characters allowed by data
    private String transactionDescription;

    @Convert(converter = YearMonthAttributeConverter.class)
    private YearMonth depositMonth;

    @Convert(converter = YearMonthAttributeConverter.class)
    private YearMonth withdrawMonth;

}
