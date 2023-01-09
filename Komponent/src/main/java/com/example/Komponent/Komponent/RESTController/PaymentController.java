package com.example.Komponent.Komponent.RESTController;

import com.example.Komponent.Komponent.model.Payment;
import com.example.Komponent.Komponent.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService PaymentService;

    public List<Payment> getPayments() {
        return PaymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable("id") int id) {
        return PaymentService.getPaymentById(id);
    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return PaymentService.savePayment(payment);
    }
    @PutMapping
    public Payment updatePayment(@RequestBody Payment payment) {
        return PaymentService.savePayment(payment);
    }
    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable("id") int id) {
        PaymentService.deletePayment(id);
    }
}
