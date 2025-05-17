package com.noventiqvp.healthcaredemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noventiqvp.healthcaredemo.domain.Alert;
import com.noventiqvp.healthcaredemo.service.AlertService;

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
