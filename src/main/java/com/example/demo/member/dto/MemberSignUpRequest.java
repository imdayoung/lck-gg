package com.example.demo.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class MemberSignUpRequest {

    private String username;
    private String password;
    private String nickname;
    private LocalDate birthday;
    private Integer age;
}
