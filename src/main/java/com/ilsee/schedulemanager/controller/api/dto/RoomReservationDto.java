package com.ilsee.schedulemanager.controller.api.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class RoomReservationDto {
	private String title;
	private LocalDateTime start;
	private LocalDateTime end;
}
