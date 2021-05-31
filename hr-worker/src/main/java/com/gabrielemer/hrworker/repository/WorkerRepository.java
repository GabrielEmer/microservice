package com.gabrielemer.hrworker.repository;

import com.gabrielemer.hrworker.domain.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
