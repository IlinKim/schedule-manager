package com.ilsee.schedulemanager.domain.reservationgroup;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationGroupRepositoryCustom {
	List<ReservationGroup> findAllReservationGroups(LocalDateTime start, LocalDateTime end);
}
