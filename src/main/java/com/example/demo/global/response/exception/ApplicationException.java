package com.example.demo.global.response.exception;

import com.example.demo.global.response.error.ApplicationError;
import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {

    private final ApplicationError error;

    public ApplicationException(ApplicationError error) {

        super(error.getMessage());
        this.error = error;
    }
}
