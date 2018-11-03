package com.ilsee.schedulemanager.domain.reservationgroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationGroupRepository extends JpaRepository<ReservationGroup, Long>, ReservationGroupRepositoryCustom {
}
