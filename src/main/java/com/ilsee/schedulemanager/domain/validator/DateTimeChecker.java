package com.ilsee.schedulemanager.domain.validator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateTimeChecker {
    private static final Integer[] VALID_MINUTES = new Integer[]{0, 30};

    public static boolean checkAll(LocalDateTime start, LocalDateTime end) {
        return checkMinute(start) && checkMinute(end) &&
                checkRange(start, end) &&
                checkSameDay(start, end);
    }

    private static boolean checkMinute(LocalDateTime dateTime) {
        return Arrays.stream(VALID_MINUTES).anyMatch(validMinute -> validMinute.equals(dateTime.getMinute()));
    }

    private static boolean checkRange(LocalDateTime start, LocalDateTime end) {
        return start.isBefore(end);
    }

    private static boolean checkSameDay(LocalDateTime start, LocalDateTime end) {
        //handle 00:00
        if (!start.toLocalDate().equals(end.toLocalDate()) && end.toLocalTime().equals(LocalTime.of(0, 0))) {
            log.debug("checkSameDay: only true");
            return true;
        }
        return start.toLocalDate().equals(end.toLocalDate());
    }


}
