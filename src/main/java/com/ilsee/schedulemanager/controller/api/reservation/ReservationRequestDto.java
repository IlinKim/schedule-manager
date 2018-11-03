package com.ilsee.schedulemanager.controller.api.reservation;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
public class ReservationRequestDto {
    public static final String CLIENT_TIME_FORMAT = "HH:mm";

    private String title;
    private String userName;
    private Long roomId;
    private Long repeatCount;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;
    @DateTimeFormat(pattern = CLIENT_TIME_FORMAT)
    private LocalTime startDate;
    @DateTimeFormat(pattern = CLIENT_TIME_FORMAT)
    private LocalTime endDate;
}
