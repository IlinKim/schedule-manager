package com.ilsee.schedulemanager.domain.validator;

import com.ilsee.schedulemanager.controller.api.reservation.ReservationRequestDto;
import com.ilsee.schedulemanager.domain.exception.ValidationErrors;
import com.ilsee.schedulemanager.domain.exception.ValidationException;
import com.ilsee.schedulemanager.domain.support.utils.DateTimeUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class ReservationRequestDateValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ReservationRequestDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ReservationRequestDto dto = (ReservationRequestDto) target;

        if (!validateDateTime(dto.getDate(), dto.getStartTime(), dto.getEndTime())) {
            throw new ValidationException(ValidationErrors.INVALID_DATE);
        }
    }

    private boolean validateDateTime(LocalDate date, LocalTime startTime, LocalTime endTime) {
        LocalDateTime start = DateTimeUtils.convert(date, startTime);
        LocalDateTime end = DateTimeUtils.convertZeroEndTime(date, endTime);

        return ReservationDateTimeChecker.checkAll(start, end);
    }
}
