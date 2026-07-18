package com.example.demo.repository; // Check kijiye ki yahan .repository hi likha ho

import com.example.demo.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}