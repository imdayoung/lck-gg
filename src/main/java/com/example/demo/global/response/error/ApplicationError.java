package com.example.demo.global.response.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ApplicationError {

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON_001", "서버 내부 에러가 발생했습니다."),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "COMMON_002", "토큰이 유효하지 않습니다."),
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "COMMON_003", "토큰의 유효기간이 만료되었습니다."),
    TOKEN_NOT_FOUND(HttpStatus.UNAUTHORIZED, "COMMON_004", "토큰을 찾을 수 없습니다."),

    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER_001", "존재하지 않는 회원입니다."),
    USERNAME_DUPLICATED(HttpStatus.BAD_REQUEST, "MEMBER_002", "이미 존재하는 아이디입니다."),
    USERNAME_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER_003", "존재하지 않는 아이디입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
