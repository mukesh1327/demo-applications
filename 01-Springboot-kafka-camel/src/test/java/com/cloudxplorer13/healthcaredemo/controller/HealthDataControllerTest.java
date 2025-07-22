package com.cloudxplorer13.healthcaredemo.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cloudxplorer13.healthcaredemo.service.HealthDataService;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HealthDataController.class)
class HealthDataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HealthDataService healthDataService;

    @Test
    void testGetAllHealthData() throws Exception {
        Mockito.when(healthDataService.getAllHealthData()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/v1/health-data"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));
    }
}
