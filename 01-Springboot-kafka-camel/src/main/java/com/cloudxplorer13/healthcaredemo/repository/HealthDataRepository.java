package com.cloudxplorer13.healthcaredemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloudxplorer13.healthcaredemo.domain.HealthData;

@Repository
public interface HealthDataRepository extends JpaRepository<HealthData, Long> {
}