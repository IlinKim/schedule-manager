package com.ilsee.schedulemanager.controller.api;

import com.google.common.collect.Iterables;
import com.ilsee.schedulemanager.controller.api.dto.RoomReservationDto;
import com.ilsee.schedulemanager.domain.reservationgroup.ReservationGroup;
import com.ilsee.schedulemanager.domain.reservationgroup.ReservationGroupRepository;
import com.ilsee.schedulemanager.domain.reservationgroup.ReservationGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequestMapping("/api/reservation")
@RestController
@RequiredArgsConstructor
public class ReservationApiController {
	Function<ReservationGroup, List<RoomReservationDto>> roomReservationDtoConverter = (reservationGroup) -> reservationGroup.getReservationList()
		.stream()
		.map(reservation -> {
			LocalDate date = reservation.getReservationCellList().get(0).getDate();
			LocalTime start = reservation.getReservationCellList().get(0).getTimeLine().getStart();
			LocalTime end = Iterables.getLast(reservation.getReservationCellList()).getTimeLine().getEnd();

			return RoomReservationDto.builder()
				.title(reservation.getTitle())
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
	public List<RoomReservationDto> listAllReservations(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
		@RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
		List<ReservationGroup> allReservationGroups = reservationGroupService.getAllReservationGroups(start, end);
		return allReservationGroups.stream()
			.map(roomReservationDtoConverter)
			.collect(ArrayList::new, List::addAll, List::addAll);
	}
}
