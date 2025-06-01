package com.security.demo.dto;

import com.security.demo.enam.TransactionMedium;
import com.security.demo.enam.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.YearMonth;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionDTO {

    private int id;
    private Double depositAmount;
    private Double withdrawAmount;
    private TransactionType transactionType;
    private LocalDate transactionDate;
    private int receiverId;
    private int senderId;
    private TransactionMedium transactionMedium;
    private String transactionDescription;
    private YearMonth depositMonth;
    private YearMonth withdrawMonth;

}

