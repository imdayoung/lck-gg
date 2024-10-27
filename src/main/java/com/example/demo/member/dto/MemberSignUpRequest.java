package com.example.demo.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberSignUpRequest {

    private String username;
    private String password;
    private String nickname;
    private Integer age;
}
