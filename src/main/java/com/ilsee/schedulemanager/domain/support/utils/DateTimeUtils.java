package com.ilsee.schedulemanager.domain.support.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateTimeUtils {
    private static final int REPEAT_INTERVAL_DAY = 7;
    private static final LocalTime ZERO_TIME = LocalTime.of(0, 0);

    public static boolean isZeroTime(LocalTime time) {
        return time.equals(ZERO_TIME);
    }

    public static LocalDateTime convert(LocalDate date, LocalTime time) {
        return LocalDateTime.of(date, time);
    }

    public static LocalDateTime convertEndTime(LocalDate date, LocalTime endTime) {
        if (endTime.equals(ZERO_TIME)) {
            return convert(date.plusDays(1), endTime);
        }
        return convert(date, endTime);
    }

    public static LocalDate getIntervalDateByIndex(LocalDate date, int index) {
        Integer addDays = REPEAT_INTERVAL_DAY * index;
        return date.plusDays(addDays);
    }
}
