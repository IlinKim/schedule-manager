package com.ilsee.schedulemanager.domain.reservationcell;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationCellRepository extends JpaRepository<ReservationCell, Long> {
}
