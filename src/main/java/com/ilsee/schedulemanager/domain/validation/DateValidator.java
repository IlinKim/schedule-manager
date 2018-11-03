package com.ilsee.schedulemanager.domain.validation;

import java.time.LocalDateTime;

public class DateValidator {
	public static boolean checkSameDay(LocalDateTime start, LocalDateTime end) {
		return start.toLocalDate().equals(end.toLocalDate());
	}
}
