package com.gabrielemer.hrpayroll.domain.service;

import com.gabrielemer.hrpayroll.domain.model.Payment;
import com.gabrielemer.hrpayroll.domain.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gabrielemer.hrpayroll.feign.WorkerFeignClient;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long workerId, Integer days) {
        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }


}
