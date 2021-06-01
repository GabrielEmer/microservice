package com.gabrielemer.hrpayroll.domain.service;

import com.gabrielemer.hrpayroll.domain.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, Integer days) {
        return new Payment("Gabriel", 200.0, days);
    }
}
