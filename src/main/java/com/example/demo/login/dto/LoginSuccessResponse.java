package com.example.demo.login.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginSuccessResponse {

    private String username;
    private String accessToken;
    private String refreshToken;
}
