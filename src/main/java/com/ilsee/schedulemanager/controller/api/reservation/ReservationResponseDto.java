package com.ilsee.schedulemanager.controller.api.reservation;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ReservationResponseDto {
	private Long id;
	private String title;
	private String roomName;
	private String color;
	private LocalDateTime start;
	private LocalDateTime end;
}
