package com.cloudxplorer13.healthcaredemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudxplorer13.healthcaredemo.domain.HealthData;
import com.cloudxplorer13.healthcaredemo.service.HealthDataService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/health-data")
@RequiredArgsConstructor
public class HealthDataController {

    private final HealthDataService healthDataService;

    @GetMapping
    public List<HealthData> getAllHealthData() {
        return healthDataService.getAllHealthData();
    }
}
