package com.scheduleapp.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {

    private String title;
    private String content;
    private String name;
    private String password;
}
