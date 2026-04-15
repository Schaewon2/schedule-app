package com.scheduleapp.controller;

import com.scheduleapp.dto.*;
import com.scheduleapp.entity.Schedule;
import com.scheduleapp.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
        // 일정 추가 Mapping
    ResponseEntity<CreateScheduleResponseDto> createSchedule(@RequestBody CreateScheduleRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.save(requestDto));
    }

    @GetMapping("/schedules/{scheduleId}")
        // 선택 일정 조회 Mapping
    ResponseEntity<GetScheduleResponseDto> getOne(@PathVariable Long scheduleId) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getSchedule(scheduleId));
    }

    @GetMapping("/schedules") // 전체 일정 조회
    public ResponseEntity<List<GetScheduleResponseDto>> getAll(@RequestParam(required = false) String name) {
        return ResponseEntity.status((HttpStatus.OK)).body(scheduleService.getSchedules(name));
    }

    @PutMapping("schedules/{scheduleId}") // 일정 수정
    public ResponseEntity<UpdateScheduleResponseDto> updateSchedule(
            @PathVariable Long scheduleId,
            @RequestParam String password,
            @RequestBody UpdateScheduleRequestDto requestDto
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.updateTitleAndName(scheduleId, password, requestDto));
    }
}
