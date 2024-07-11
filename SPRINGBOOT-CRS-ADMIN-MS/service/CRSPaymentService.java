package com.boa.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.app.entity.Payment;
import com.boa.app.repo.PaymentRepo;


@Service
public class CRSPaymentService {
	
	@Autowired
    private PaymentRepo paymentRepo;

    public Payment savePayment(Payment payment) {
        return paymentRepo.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }

    public Payment getPaymentById(Long id) {
        return paymentRepo.findById(id).orElse(null);
    }

    public void deletePayment(Long id) {
        paymentRepo.deleteById(id);
    }

}
