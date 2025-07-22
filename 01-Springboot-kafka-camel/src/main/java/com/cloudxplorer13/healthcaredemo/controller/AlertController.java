package com.cloudxplorer13.healthcaredemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudxplorer13.healthcaredemo.domain.Alert;
import com.cloudxplorer13.healthcaredemo.service.AlertService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AlertController {

    private final AlertService alertService;

    @GetMapping("/api/v1/alerts")
    public List<Alert> getAllAlerts() {
        return alertService.getAllGeneratedAlerts();
    }
}
