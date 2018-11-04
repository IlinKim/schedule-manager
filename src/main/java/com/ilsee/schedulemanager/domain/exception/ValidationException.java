package com.ilsee.schedulemanager.domain.exception;

import lombok.Getter;

import javax.servlet.http.HttpServletResponse;

@Getter
public class ValidationException extends RuntimeException {
    private String message;
    private Integer code;

    public ValidationException(ValidationErrors errors) {
        this(errors, HttpServletResponse.SC_BAD_REQUEST);
    }

    public ValidationException(ValidationErrors errors, int code) {
        super(errors.getMessage());
        this.message = errors.getMessage();
        this.code = code;
    }
}
