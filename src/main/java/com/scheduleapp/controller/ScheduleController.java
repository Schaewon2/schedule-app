package com.scheduleapp.controller;

import com.scheduleapp.dto.CreateScheduleRequestDto;
import com.scheduleapp.dto.CreateScheduleResponseDto;
import com.scheduleapp.entity.Schedule;
import com.scheduleapp.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    ResponseEntity<CreateScheduleResponseDto> createSchedule(@RequestBody CreateScheduleRequestDto requestDto) {
        CreateScheduleResponseDto result = scheduleService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }


}
