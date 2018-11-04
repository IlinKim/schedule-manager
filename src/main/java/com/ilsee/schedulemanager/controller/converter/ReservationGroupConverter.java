package com.ilsee.schedulemanager.controller.converter;

import com.google.common.collect.Sets;
import com.ilsee.schedulemanager.controller.api.reservation.ReservationRequestDto;
import com.ilsee.schedulemanager.domain.exception.ValidationErrors;
import com.ilsee.schedulemanager.domain.exception.ValidationException;
import com.ilsee.schedulemanager.domain.reservation.Reservation;
import com.ilsee.schedulemanager.domain.reservationcell.ReservationCell;
import com.ilsee.schedulemanager.domain.reservationgroup.ReservationGroup;
import com.ilsee.schedulemanager.domain.room.Room;
import com.ilsee.schedulemanager.domain.room.RoomRepository;
import com.ilsee.schedulemanager.domain.support.utils.DateTimeUtils;
import com.ilsee.schedulemanager.domain.timeline.TimeLine;
import com.ilsee.schedulemanager.domain.timeline.TimeLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ReservationGroupConverter implements Function<ReservationRequestDto, ReservationGroup> {
    private final RoomRepository roomRepository;
    private final TimeLineRepository timeLineRepository;

    @Override
    public ReservationGroup apply(ReservationRequestDto reservationRequestDto) {
        return makeReservationGroup(reservationRequestDto);
    }

    private ReservationGroup makeReservationGroup(ReservationRequestDto reservationRequestDto) {
        return ReservationGroup.of(makeReservations(reservationRequestDto));
    }

    private Set<Reservation> makeReservations(ReservationRequestDto reservationRequestDto) {
        Set<Reservation> resultSet = Sets.newHashSet();

        String title = reservationRequestDto.getTitle();
        String userName = reservationRequestDto.getUserName();

        for (int index = 0; index < reservationRequestDto.getRepeatCount(); index++) {
            List<ReservationCell> b = makeReservationCells(reservationRequestDto, index);
            Reservation a = Reservation.of(title, userName, b);
            resultSet.add(a);
        }
        return resultSet;
    }

    private List<ReservationCell> makeReservationCells(ReservationRequestDto reservationRequestDto, int index) {
        Long roomId = reservationRequestDto.getRoomId();
        LocalDate date = DateTimeUtils.getIntervalDateByIndex(reservationRequestDto.getDate(), index);
        LocalTime startTime = reservationRequestDto.getStartTime();
        LocalTime endTime = reservationRequestDto.getEndTime();

        Room room = roomRepository.findById(roomId).orElseThrow(() -> new ValidationException(ValidationErrors.INVALID_ROOM));
        List<TimeLine> timeLines = timeLineRepository.findAllByStartGreaterThanEqualAndEndLessThanEqual(startTime, endTime);

        return timeLines.stream()
                .filter(filterLastTimeLineWhenNotIncludeLastEnd(endTime))
                .map(timeLine -> ReservationCell.of(room, date, timeLine))
                .collect(Collectors.toList());
    }

    private Predicate<TimeLine> filterLastTimeLineWhenNotIncludeLastEnd(LocalTime endTime) {
        return timeLine -> isNotLastTimeLine(timeLine) || isLastTime(endTime);
    }

    private boolean isLastTime(LocalTime endTime) {
        return DateTimeUtils.isZeroTime(endTime);
    }

    private boolean isNotLastTimeLine(TimeLine timeLine) {
        return !DateTimeUtils.isZeroTime(timeLine.getEnd());
    }
}
