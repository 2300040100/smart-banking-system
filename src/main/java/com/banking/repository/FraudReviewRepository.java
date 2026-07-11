package com.banking.repository;

import com.banking.entity.FraudReview;
import com.banking.entity.ReviewDecision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FraudReviewRepository 
    extends JpaRepository<FraudReview, String> {
    List<FraudReview> findByTransactionId(String transactionId);
    List<FraudReview> findByReviewedById(String userId);
    List<FraudReview> findByDecision(ReviewDecision decision);
}