package com.example.demo.schedule.controller;

import com.example.demo.global.response.response.ApiResponse;
import com.example.demo.schedule.dto.ScheduleResponse;
import com.example.demo.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping()
    public ResponseEntity<ApiResponse<List<ScheduleResponse>>> getGameSchedule() {

        List<ScheduleResponse> response = scheduleService.getGameSchedule();
        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
