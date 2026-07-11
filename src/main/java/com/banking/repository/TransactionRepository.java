package com.banking.repository;

import com.banking.entity.Transaction;
import com.banking.entity.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository 
    extends JpaRepository<Transaction, String> {
    
    List<Transaction> findByAccountId(String accountId);
    List<Transaction> findByReferenceId(String referenceId);
    List<Transaction> findByStatus(TransactionStatus status);
    List<Transaction> findByAccountIdAndStatus(
        String accountId, TransactionStatus status);
    
    @Query("SELECT COUNT(t) FROM Transaction t " +
           "WHERE t.account.id = :accountId " +
           "AND t.createdAt >= :since")
    Long countRecentTransactions(
        @Param("accountId") String accountId,
        @Param("since") LocalDateTime since);
}