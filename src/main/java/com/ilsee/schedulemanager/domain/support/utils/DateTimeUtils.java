package com.ilsee.schedulemanager.domain.support.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateTimeUtils {

    public static boolean isZeroTime(LocalTime time) {
        return time.equals(LocalTime.of(0, 0));
    }

    public static LocalDateTime convert(LocalDate date, LocalTime time) {
        return LocalDateTime.of(date, time);
    }

    public static LocalDateTime convertEndTime(LocalDate date, LocalTime endTime) {
        if (endTime.equals(LocalTime.of(0,0))) {
            return convert(date.plusDays(1), endTime);
        }
        return convert(date, endTime);
    }
}
