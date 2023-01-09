package com.example.Komponent.Komponent.repository;

import com.example.Komponent.Komponent.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentRepo extends JpaRepository<Payment, Integer> {
}
