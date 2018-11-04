package com.ilsee.schedulemanager.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ValidationErrors {
    COMMON("Invalid Input"),
    INVALID_ROOM("Invalid Room"),
    INVALID_DATE("Invalid Date");

    private String message;
}
