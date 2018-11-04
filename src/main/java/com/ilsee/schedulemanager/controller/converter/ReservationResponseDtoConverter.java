package com.ilsee.schedulemanager.controller.converter;

import com.google.common.collect.Iterables;
import com.ilsee.schedulemanager.controller.api.reservation.ReservationResponseDto;
import com.ilsee.schedulemanager.domain.reservationcell.ReservationCell;
import com.ilsee.schedulemanager.domain.reservationgroup.ReservationGroup;
import com.ilsee.schedulemanager.domain.support.utils.DateTimeUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ReservationResponseDtoConverter implements Function<ReservationGroup, List<ReservationResponseDto>> {
    @Override
    public List<ReservationResponseDto> apply(ReservationGroup reservationGroup) {
        return reservationGroup.getReservationList()
                .stream()
                .map(reservation -> {
                    reservation.getReservationCellList().sort(Comparator.comparing(ReservationCell::getId));

                    ReservationCell firstReservationCell = reservation.getReservationCellList().get(0);
                    ReservationCell lastReservationCell = Iterables.getLast(reservation.getReservationCellList());

                    String roomName = firstReservationCell.getRoom().getRoomName();
                    String color = firstReservationCell.getRoom().getRoomColor();
                    LocalDate date = firstReservationCell.getDate();
                    LocalTime start = firstReservationCell.getTimeLine().getStart();
                    LocalTime end = lastReservationCell.getTimeLine().getEnd();

                    return ReservationResponseDto.builder()
                            .id(reservationGroup.getId())
                            .title(reservation.getTitle())
                            .roomName(roomName)
                            .color(color)
                            .start(DateTimeUtils.convert(date, start))
                            .end(DateTimeUtils.convertEndTime(date, end))
                            .build();
                }).collect(Collectors.toList());
    }
}
