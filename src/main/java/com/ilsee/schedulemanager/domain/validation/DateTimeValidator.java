package com.ilsee.schedulemanager.domain.validation;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateTimeValidator {
	public static boolean checkSameDay(LocalDateTime start, LocalDateTime end) {
		return start.toLocalDate().equals(end.toLocalDate());
	}

	public static boolean checkRange(LocalDateTime start, LocalDateTime end) {
		return start.isBefore(end);
	}

	public static boolean checkMinute(LocalDateTime dateTime) {
		return dateTime.getMinute() == 0 || dateTime.getMinute() == 30;
	}

}
