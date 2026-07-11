package com.banking.repository;

import com.banking.entity.FraudRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FraudRuleRepository 
    extends JpaRepository<FraudRule, String> {
    List<FraudRule> findByIsActiveTrue();
    boolean existsByRuleName(String ruleName);
}