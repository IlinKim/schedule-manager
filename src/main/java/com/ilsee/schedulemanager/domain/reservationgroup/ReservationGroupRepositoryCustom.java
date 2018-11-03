package com.ilsee.schedulemanager.domain.reservationgroup;

import java.time.LocalDate;
import java.util.List;

public interface ReservationGroupRepositoryCustom {
	List<ReservationGroup> findAllReservationGroups(LocalDate start, LocalDate end);
}
