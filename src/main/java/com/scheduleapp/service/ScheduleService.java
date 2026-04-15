package com.scheduleapp.service;

import com.scheduleapp.dto.*;
import com.scheduleapp.entity.Schedule;
import com.scheduleapp.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    // POST (일정 추가)
    @Transactional
    public CreateScheduleResponseDto save(@RequestBody CreateScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule(
                requestDto.getTitle(),
                requestDto.getContent(),
                requestDto.getName(),
                requestDto.getPassword()
        );
        Schedule saveSchedule = scheduleRepository.save(schedule);

        return new CreateScheduleResponseDto(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getName(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    // GET (선택 일정 조회)
    @Transactional(readOnly = true)
    public GetScheduleResponseDto getSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );

        return new GetScheduleResponseDto(schedule);
    }

    // GET (전체 일정 조회)
    @Transactional(readOnly = true)
    public List<GetScheduleResponseDto> getSchedules(String name) {
        List<Schedule> schedules;
        if (name != null) {
            schedules = scheduleRepository.findAllByNameOrderByModifiedAtDesc(name);
        } else {
            schedules = scheduleRepository.findAllByOrderByModifiedAtDesc();
        }

        List<GetScheduleResponseDto> dtos = new ArrayList<>();

        for (Schedule schedule : schedules) {
            GetScheduleResponseDto dto = new GetScheduleResponseDto(schedule);
            dtos.add(dto);
        }

        return dtos;
    }

    // PUT (일정 수정)
    @Transactional
    public UpdateScheduleResponseDto updateTitleAndName(Long scheduleId, String password, UpdateScheduleRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );

        if (schedule.getPassword() == null || !schedule.getPassword().equals(password)) {
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }

        schedule.updateTitleAndName(requestDto.getTitle(), requestDto.getName());
        return new UpdateScheduleResponseDto(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getName()
        );
    }

    // DELETE (일정 삭제)
    @Transactional
    public void delete(Long scheduleId, String password) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );

        if (!schedule.getPassword().equals(password)) {
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }

        scheduleRepository.delete(schedule);
    }
}
