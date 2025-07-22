package com.cloudxplorer13.healthcaredemo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.cloudxplorer13.healthcaredemo.domain.HealthData;
import com.cloudxplorer13.healthcaredemo.repository.HealthDataRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HealthDataService {

    private final HealthDataRepository healthDataRepository;

    public void addHealthData(HealthData data) {
        log.info("Saving Health Data to Database: {}", data);
        healthDataRepository.save(data);
    }

    public List<HealthData> getAllHealthData() {
        return healthDataRepository.findAll();
    }
}
