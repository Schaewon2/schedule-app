package com.scheduleapp.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 */

@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseEntity {
    // 속성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 아이디 (id 차등 부여)
    private String title; // 일정 제목
    private String content; // 일정 내용
    private String name; // 작성자명
    private String password; // 비밀번호

    // 생성자
    public Schedule(String title, String contents, String name, String password) {
        this.title = title;
        this.content = contents;
        this.name = name;
        this.password = password;
    }

    // 기능
}
