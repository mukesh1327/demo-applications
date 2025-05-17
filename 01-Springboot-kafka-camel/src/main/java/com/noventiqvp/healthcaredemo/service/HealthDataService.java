package com.noventiqvp.healthcaredemo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.noventiqvp.healthcaredemo.domain.HealthData;
import com.noventiqvp.healthcaredemo.repository.HealthDataRepository;

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
