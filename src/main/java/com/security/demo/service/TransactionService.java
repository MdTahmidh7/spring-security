package com.security.demo.service;

import com.security.demo.dto.TransactionDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public interface TransactionService {

    TransactionDTO createTransaction(TransactionDTO transactionDTO);

    Page<TransactionDTO> getAllTransactions(
            LocalDate filterFromDate,
            LocalDate filterToDate,
            int pageNo,
            int pageSize);
}
