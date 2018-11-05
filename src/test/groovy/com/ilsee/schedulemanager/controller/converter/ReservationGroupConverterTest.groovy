package com.ilsee.schedulemanager.controller.converter

import com.ilsee.schedulemanager.controller.api.reservation.ReservationRequestDto
import com.ilsee.schedulemanager.domain.reservation.Reservation
import com.ilsee.schedulemanager.domain.reservationcell.ReservationCell
import com.ilsee.schedulemanager.domain.room.Room
import com.ilsee.schedulemanager.domain.room.RoomRepository
import com.ilsee.schedulemanager.domain.timeline.TimeLine
import com.ilsee.schedulemanager.domain.timeline.TimeLineRepository
import spock.lang.Specification
import spock.lang.Unroll

import java.time.LocalDate
import java.time.LocalTime

class ReservationGroupConverterTest extends Specification {
    RoomRepository roomRepository = Mock(RoomRepository) {
        findById(_) >> Optional.of(new Room(id: 1L, roomName: "테스트 미팅룸", roomColor: "#696C85"))
    }
    TimeLineRepository timeLineRepository = Mock(TimeLineRepository) {
        findAllByStartGreaterThanEqual(_) >>
                [new TimeLine(id: 1L, start: LocalTime.of(23,0), end: LocalTime.of(23,30)),
                 new TimeLine(id: 2L, start: LocalTime.of(23,30), end: LocalTime.of(0,0))]
        findAllByStartGreaterThanEqualAndEndLessThanEqual(_,_) >>
                [new TimeLine(id: 1L, start: LocalTime.of(23,0), end: LocalTime.of(23,30)),
                 new TimeLine(id: 2L, start: LocalTime.of(23,30), end: LocalTime.of(0,0))]
    }
    @Unroll
    def "Reservation Group 반복예약 테스트: #DESC"() {
        setup:
        ReservationGroupConverter converter = new ReservationGroupConverter(roomRepository,timeLineRepository)

        when:
        def result = converter.apply(new ReservationRequestDto(
                title: "테스트",
                userName:"테스트유저",
                roomId: 1L,
                repeatCount: REPEAT_COUNT,
                date: LocalDate.now(),
                startTime: LocalTime.of(23, 30),
                endTime: LocalTime.of(0,0)))

        then:
		result.reservationList.size() == RESERVATION_LIST_SIZE

        where:
        DESC | REPEAT_COUNT | RESERVATION_LIST_SIZE
		"반복예약 테스트: 1개 예약" | 1 | 1
		"반복예약 테스트: 2개 예약" | 2 | 2
    }

    @Unroll
    def "Reservation Group 생성 테스트: #DESC"() {
        setup:
        ReservationGroupConverter converter = new ReservationGroupConverter(roomRepository,timeLineRepository)

        when:
        def result = converter.apply(new ReservationRequestDto(
                title: "테스트",
                userName:"테스트유저",
                roomId: 1L,
                repeatCount: 1,
                date: LocalDate.now(),
                startTime: LocalTime.of(23, 0),
                endTime: END_TIME))

        then:
        result.reservationList.iterator().next() == new Reservation(reservationCellList: RESULT_CELL_LIST)

        where:
        DESC | END_TIME | RESULT_CELL_LIST
        "예약시간이 23:00 ~ 00:00 일 경우, 23:00 ~ 00:00 2개 cell 생성" |
                LocalTime.of(0,0) |
                [new ReservationCell(room: new Room(id: 1L), date: LocalDate.now(), timeLine: new TimeLine(id: 1L)),
                 new ReservationCell(room: new Room(id: 1L), date: LocalDate.now(), timeLine: new TimeLine(id: 2L))]
        "예약시간이 23:00 ~ 23:30 일 경우, 23:00~23:30 1개 cell 생성" |
                LocalTime.of(23,30) |
                [new ReservationCell(room: new Room(id: 1L), date: LocalDate.now(), timeLine: new TimeLine(id: 1L))]
    }

}
