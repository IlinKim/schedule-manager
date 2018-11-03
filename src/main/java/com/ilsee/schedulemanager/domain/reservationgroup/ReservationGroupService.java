package com.ilsee.schedulemanager.domain.reservationgroup;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationGroupService {
	private final ReservationGroupRepository reservationGroupRepository;

	@Transactional(readOnly = true)
	public List<ReservationGroup> getAllReservationGroups(LocalDateTime start, LocalDateTime end) {
		return reservationGroupRepository.findAllReservationGroups(start, end);
	}
}
