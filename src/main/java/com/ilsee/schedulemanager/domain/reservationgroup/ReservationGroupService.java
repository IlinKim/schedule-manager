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
        return reservationGroupRepository.findAllReservationGroupsBetweenDates(start, end);
    }

    @Transactional
    public void saveReservation(ReservationGroup group) {
        reservationGroupRepository.save(group);
    }
}
