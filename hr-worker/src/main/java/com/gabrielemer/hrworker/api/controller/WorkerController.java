package com.gabrielemer.hrworker.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gabrielemer.hrworker.domain.model.Worker;
import com.gabrielemer.hrworker.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerController {


    private static Logger logger = LoggerFactory.getLogger(WorkerRepository.class);

    @Value("${test.config}")
    private String testConfig;

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs() {
        logger.info("CONFIG = " + testConfig);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        return ResponseEntity.ok(workerRepository.findAll());
    }

    @GetMapping("/{workerId}")
    public ResponseEntity<Worker> findById(@PathVariable Long workerId) {
/*
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/
        Optional<Worker> worker = workerRepository.findById(workerId);
        return worker.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
