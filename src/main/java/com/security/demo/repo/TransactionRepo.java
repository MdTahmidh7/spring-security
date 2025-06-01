package com.security.demo.repo;

import com.security.demo.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {

    @Query("""
    SELECT transaction
    FROM Transaction transaction
    WHERE transaction.transactionDate between :filterFromDate and :filterToDate
    ORDER BY transaction.transactionDate DESC
    """)
    Page<Transaction> findAll(
            LocalDate filterFromDate,
            LocalDate filterToDate,
            Pageable pageable
    );
}
