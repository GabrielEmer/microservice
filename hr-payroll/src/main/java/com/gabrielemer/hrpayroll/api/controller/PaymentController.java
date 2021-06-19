package com.gabrielemer.hrpayroll.api.controller;
import com.gabrielemer.hrpayroll.domain.model.Payment;
import com.gabrielemer.hrpayroll.domain.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping("/{workerId}/days/{workedDays}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer workedDays) {
        Payment payment = paymentService.getPayment(workerId, workedDays);
        return ResponseEntity.ok(payment);
    }

    public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer workedDays) {
        Payment payment = new Payment("Bran", 400.0, workedDays);
        return ResponseEntity.ok(payment);
    }
}
