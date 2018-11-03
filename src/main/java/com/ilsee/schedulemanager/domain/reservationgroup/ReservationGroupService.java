package com.ilsee.schedulemanager.domain.reservationgroup;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationGroupService {
	private final ReservationGroupRepository reservationGroupRepository;

	@Transactional(readOnly = true)
	public List<ReservationGroup> getAllReservationGroups(LocalDate start, LocalDate end) {
		return reservationGroupRepository.findAllReservationGroups(start, end);
	}

	@Transactional
	public void saveReservation() {
		//TODO: Date Validation, Error 처리 등
//		DateTimeValidator.checkSameDay();
//		DateTimeValidator.checkRange();
	}
}
