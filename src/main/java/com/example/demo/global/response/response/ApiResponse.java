package com.example.demo.global.response.response;

import com.example.demo.global.response.error.ApplicationError;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiResponse<T> {

    private boolean success;
    private T payload;
    private ErrorResponse error;

    public static <T> ApiResponse<T> success(T payload) {

        return ApiResponse.<T>builder()
                .success(true)
                .payload(payload)
                .build();
    }

    public static ApiResponse<ErrorResponse> failure(ErrorResponse error) {

        return ApiResponse.<ErrorResponse>builder()
                .success(false)
                .error(error)
                .build();
    }
}
