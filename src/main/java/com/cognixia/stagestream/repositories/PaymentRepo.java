package com.cognixia.stagestream.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.stagestream.models.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long>{

}
