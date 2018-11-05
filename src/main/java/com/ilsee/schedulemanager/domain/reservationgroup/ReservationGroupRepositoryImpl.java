package com.ilsee.schedulemanager.domain.reservationgroup;

import com.ilsee.schedulemanager.domain.reservation.QReservation;
import com.ilsee.schedulemanager.domain.reservationcell.QReservationCell;
import com.ilsee.schedulemanager.domain.timeline.QTimeLine;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.time.LocalDate;
import java.util.List;

public class ReservationGroupRepositoryImpl extends QuerydslRepositorySupport implements ReservationGroupRepositoryCustom {
    private final QReservationGroup qReservationGroup = QReservationGroup.reservationGroup;
    private final QReservation qReservation = QReservation.reservation;
    private final QReservationCell qReservationCell = QReservationCell.reservationCell;
    private final QTimeLine qTimeLine = QTimeLine.timeLine;

    public ReservationGroupRepositoryImpl() {
        super(ReservationGroup.class);
    }

    @Override
    public List<ReservationGroup> findAllReservationGroupsBetweenDates(LocalDate start, LocalDate end) {
        return from(qReservationGroup)
                .leftJoin(qReservationGroup.reservationList, qReservation).fetchJoin()
                .leftJoin(qReservation.reservationCellList, qReservationCell).fetchJoin()
                .where(qReservationCell.date.goe(start)
                        .and(qReservationCell.date.loe(end)))
                .orderBy(qReservationGroup.id.desc())
                .distinct()
                .fetch();
    }
}
