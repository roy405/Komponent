package com.example.Komponent.Komponent.services;

import com.example.Komponent.Komponent.model.Payment;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PaymentService {

    Payment savePayment(Payment Payment);

    Payment getPaymentById(int id);

    void deletePayment(int id);

    List<Payment> getAllPayments();
}
