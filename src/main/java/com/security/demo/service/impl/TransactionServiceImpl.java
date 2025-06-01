package com.security.demo.service.impl;

import com.security.demo.dto.TransactionDTO;
import com.security.demo.entity.Transaction;
import com.security.demo.mapper.TransactionMapper;
import com.security.demo.repo.TransactionRepo;
import com.security.demo.service.TransactionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TransactionServiceImpl implements TransactionService {


    private final TransactionRepo transactionRepo;
    private final TransactionMapper transactionMapper;

    public TransactionServiceImpl(TransactionRepo transactionRepo,
                                  TransactionMapper transactionMapper
    ) {
        this.transactionRepo = transactionRepo;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {

        Transaction transaction = transactionRepo
                .save(transactionMapper.toEntity(transactionDTO));

        return transactionMapper.toDTO(transaction);
    }

    @Override
    public Page<TransactionDTO> getAllTransactions(
            LocalDate filterFromDate,
            LocalDate filterToDate,
            int pageNo,
            int pageSize
    ) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Transaction> transactions = transactionRepo.findAll(
                filterFromDate,
                filterToDate,
                pageable
        );

        return transactions.map(transactionMapper::toDTO);
    }
}
