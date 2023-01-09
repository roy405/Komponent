package com.example.Komponent.Komponent.services;

;
import com.example.Komponent.Komponent.model.Payment;
import com.example.Komponent.Komponent.repository.PaymentRepo;
import com.example.Komponent.Komponent.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImplementation implements PaymentService {

    @Autowired
    private PaymentRepo repository;


    @Override
    public Payment savePayment(Payment Payment) {
        return repository.save(Payment);
    }

    @Override
    public Payment getPaymentById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deletePayment(int id) {
        Payment Payment = repository.findById(id).orElse(null);
        repository.delete(Payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return repository.findAll();
    }
}
