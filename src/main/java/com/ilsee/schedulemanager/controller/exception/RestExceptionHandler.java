package com.ilsee.schedulemanager.controller.exception;

import com.ilsee.schedulemanager.domain.exception.ValidationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    private static final String SERVER_ERROR_MESSAGE = "Server Error Occurred.";
    private static final String ALREADY_RESERVATION_MESSAGE = "해당시간에 예약이 존재합니다.";

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, SERVER_ERROR_MESSAGE,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    protected ResponseEntity<Object> handleUniqViolation(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, ALREADY_RESERVATION_MESSAGE,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {ValidationException.class})
    protected ResponseEntity<Object> handleValidation(RuntimeException ex, WebRequest request) {
        ValidationException exception = (ValidationException) ex;
        return handleExceptionInternal(ex, exception.getMessage(),
                new HttpHeaders(), HttpStatus.valueOf(exception.getCode()), request);
    }
}
