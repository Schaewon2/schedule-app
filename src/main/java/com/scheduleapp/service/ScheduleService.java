package com.scheduleapp.service;

import com.scheduleapp.dto.CreateScheduleRequestDto;
import com.scheduleapp.dto.CreateScheduleResponseDto;
import com.scheduleapp.entity.Schedule;
import com.scheduleapp.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    // POST
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
                saveSchedule.getId(),
                saveSchedule.getTitle(),
                saveSchedule.getContent(),
                saveSchedule.getName(),
                saveSchedule.getCreatedAt(),
                saveSchedule.getModifiedAt()
        );
    }


}
