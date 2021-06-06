package com.gabrielemer.hrpayroll.feign;

import com.gabrielemer.hrpayroll.domain.model.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker", url = "http://localhost:8001", path = "/workers")
public interface WorkerFeignClient {

    @GetMapping("/{workerId}")
    ResponseEntity<Worker> findById(@PathVariable Long workerId);

}
