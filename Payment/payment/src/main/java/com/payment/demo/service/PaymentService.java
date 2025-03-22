package com.payment.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.demo.entity.Payment;
import com.payment.demo.repository.PaymentRepository;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment processPayment(Long userId, Double amount) {
    	 if (paymentRepository.findById(userId).isPresent()) {
             throw new RuntimeException("Payment already completed for this user!");
         }
        Payment payment = new Payment();
        payment.setUserId(userId);
        payment.setAmount(amount);
        payment.setStatus("PAID");
        return paymentRepository.save(payment);
    }
}
