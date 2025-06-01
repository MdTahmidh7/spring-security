package com.security.demo.controller;

import com.security.demo.dto.TransactionDTO;
import com.security.demo.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RestController
public class Transaction {

    private final TransactionService transactionService;

    public Transaction(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    //create a post method for transaction
    @PostMapping("/transaction")
    public ResponseEntity<TransactionDTO> createTransaction(
            @RequestBody TransactionDTO transactionDTO
    ){

        return ResponseEntity.ok(transactionService.createTransaction(transactionDTO));
    }

    //create a get method for transaction with pagination
    //add date filter
    @GetMapping("/transactions")
    public ResponseEntity<Page<TransactionDTO>> getAllTransactions(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate filterFromDate,  // Explicit format
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate filterToDate
    ){

        log.info("Received dates: From={}, To={}", filterFromDate, filterToDate);

        return ResponseEntity.ok(transactionService.getAllTransactions(
                filterFromDate,
                filterToDate,
                pageNo,
                pageSize));
    }

}
