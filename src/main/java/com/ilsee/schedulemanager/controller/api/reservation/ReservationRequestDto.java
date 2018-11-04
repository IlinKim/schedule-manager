package com.ilsee.schedulemanager.controller.api.reservation;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@ToString
public class ReservationRequestDto {
    public static final String CLIENT_TIME_FORMAT = "HH:mm";

    @NotEmpty
    private String title;
    @NotEmpty
    private String userName;
    @NotNull
    private Long roomId;
    @Min(1)
    @Max(10)
    @NotNull
    private Integer repeatCount;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;
    @DateTimeFormat(pattern = CLIENT_TIME_FORMAT)
    private LocalTime startTime;
    @DateTimeFormat(pattern = CLIENT_TIME_FORMAT)
    private LocalTime endTime;
}
