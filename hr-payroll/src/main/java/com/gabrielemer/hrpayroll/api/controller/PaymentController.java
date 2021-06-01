package com.gabrielemer.hrpayroll.api.controller;

import com.gabrielemer.hrpayroll.domain.model.Payment;
import com.gabrielemer.hrpayroll.domain.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{workerId}/days/{workedDays}")
    private ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer workedDays) {
        Payment payment = paymentService.getPayment(workerId, workedDays);
        return ResponseEntity.ok(payment);
    }
}
