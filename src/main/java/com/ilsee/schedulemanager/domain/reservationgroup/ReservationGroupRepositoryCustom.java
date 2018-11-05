package com.ilsee.schedulemanager.domain.reservationgroup;

import java.time.LocalDate;
import java.util.List;

public interface ReservationGroupRepositoryCustom {
	List<ReservationGroup> findAllReservationGroupsBetweenDates(LocalDate start, LocalDate end);
}
