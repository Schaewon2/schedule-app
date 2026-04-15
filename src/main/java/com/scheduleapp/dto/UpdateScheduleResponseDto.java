package com.scheduleapp.dto;

public class UpdateScheduleResponseDto {
    private final Long id;
    private final String title; // 일정 제목
    private final String name; // 작성자명

    public UpdateScheduleResponseDto(Long id, String title, String name) {
        this.id = id;
        this.title = title;
        this.name = name;
    }
}
