package com.banking.repository;

import com.banking.entity.Account;
import com.banking.entity.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    List<Account> findByUserId(String userId);
    Optional<Account> findByAccountNumber(String accountNumber);
    Boolean existsByAccountNumber(String accountNumber);
    List<Account> findByUserIdAndStatus(String userId, AccountStatus status);
}