package com.example.demo.global.response.handler;

import com.example.demo.global.response.error.ApplicationError;
import com.example.demo.global.response.exception.ApplicationException;
import com.example.demo.global.response.response.ApiResponse;
import com.example.demo.global.response.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ApiResponse<ErrorResponse>> handleApplicationException(ApplicationException e) {

        ApplicationError error = e.getError();
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(error.getCode())
                .message(error.getMessage())
                .build();

        ApiResponse<ErrorResponse> response = ApiResponse.failure(errorResponse);
        return new ResponseEntity<>(response, error.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<ErrorResponse>> handleException() {

        ApplicationError error = ApplicationError.INTERNAL_SERVER_ERROR;
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(error.getCode())
                .message(error.getMessage())
                .build();

        ApiResponse<ErrorResponse> response = ApiResponse.failure(errorResponse);
        return new ResponseEntity<>(response, error.getStatus());
    }
}
