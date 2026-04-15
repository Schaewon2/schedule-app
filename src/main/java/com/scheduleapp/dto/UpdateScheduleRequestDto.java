package com.scheduleapp.dto;

import lombok.Getter;

@Getter
public class UpdateScheduleRequestDto {
    private String title; // 일정 제목
    private String name; // 작성자명
    private String password; // 비밀번호

}
