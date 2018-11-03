package com.ilsee.schedulemanager.controller.api.reservation;

import com.google.common.collect.Iterables;
import com.ilsee.schedulemanager.domain.reservationgroup.ReservationGroup;
import com.ilsee.schedulemanager.domain.reservationgroup.ReservationGroupRepository;
import com.ilsee.schedulemanager.domain.reservationgroup.ReservationGroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@RequestMapping("/api/reservation")
@RestController
@RequiredArgsConstructor
public class ReservationApiController {
    Function<ReservationGroup, List<ReservationResponseDto>> roomReservationDtoConverter = (reservationGroup) -> reservationGroup.getReservationList()
            .stream()
            .map(reservation -> {
                String roomName = reservation.getReservationCellList().get(0).getRoom().getRoomName();
                String color = reservation.getReservationCellList().get(0).getRoom().getRoomColor();
                LocalDate date = reservation.getReservationCellList().get(0).getDate();
                LocalTime start = reservation.getReservationCellList().get(0).getTimeLine().getStart();
                LocalTime end = Iterables.getLast(reservation.getReservationCellList()).getTimeLine().getEnd();

                return ReservationResponseDto.builder()
                        .id(reservationGroup.getId())
                        .title(reservation.getTitle())
                        .roomName(roomName)
                        .color(color)
                        .start(LocalDateTime.of(date, start))
                        .end(LocalDateTime.of(date, end))
                        .build();
            }).collect(Collectors.toList());

    private final ReservationGroupService reservationGroupService;
    private final ReservationGroupRepository reservationGroupRepository;

    @GetMapping("test")
    public List<String> test() {
        List<ReservationGroup> collect = reservationGroupRepository.findAll();
        return null;
    }

    @GetMapping("list")
    public List<ReservationResponseDto> listAllReservations(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        List<ReservationGroup> allReservationGroups = reservationGroupService.getAllReservationGroups(start.toLocalDate(), end.toLocalDate());
        return allReservationGroups.stream()
                .map(roomReservationDtoConverter)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @PostMapping("save")
    public void saveReservation(ReservationRequestDto reservationRequestDto) {
        log.info("############ save!!!");
    }
}
