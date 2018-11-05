//package com.ilsee.schedulemanager.controller.converter
//
//import com.ilsee.schedulemanager.domain.reservation.Reservation
//import com.ilsee.schedulemanager.domain.room.Room
//import com.ilsee.schedulemanager.domain.room.RoomRepository
//import com.ilsee.schedulemanager.domain.timeline.TimeLine
//import com.ilsee.schedulemanager.domain.timeline.TimeLineRepository
//import spock.lang.Specification
//import spock.lang.Unroll
//
//import java.time.LocalTime
//
//class ReservationGroupConverterTest extends Specification {
//    @Unroll
//    def "Reservation Group 생성: #DESC"() {
//        setup:
//        def roomRepository = Mock(RoomRepository) {
//            findById(_) >> new Room(id: 1L, roomName: "테스트 미팅룸", roomColor: "#696C85")
//        }
//        def timeLineRepository = Mock(TimeLineRepository) {
//            findAllByStartGreaterThanEqual(_) >> [new TimeLine(id: 1L, start: LocalTime.of(23,30), end: LocalTime.of(0,0))]
//            findAllByStartGreaterThanEqualAndEndLessThanEqual(_,_) >> [new TimeLine(id: 1L, start: LocalTime.of(23,0), end: LocalTime.of(23,30))]
//        }
//
//        ReservationGroupConverter converter = new ReservationGroupConverter(roomRepository: roomRepository, timeLineRepository: timeLineRepository)
//
//        when:
//        def result = converter.apply(RESERVATION_DTO)
//
//        then:
//        result.reservationList.equals(new Reservation(reservationCellList: RESULT_CELL_LIST))
//
//        where:
//        DESC | RESERVATION_DTO | RESULT_CELL_LIST
//
//    }
//}
