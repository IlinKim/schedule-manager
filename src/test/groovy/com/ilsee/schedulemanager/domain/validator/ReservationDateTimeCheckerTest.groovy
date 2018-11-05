package com.ilsee.schedulemanager.domain.validator

import spock.lang.Specification
import spock.lang.Unroll

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class ReservationDateTimeCheckerTest extends Specification {
    @Unroll
    def "예약 start 시간과 end 시간 check: #DESC"() {
        setup:
        def startTime = START
        def endTime = END

        when:
        def result = ReservationDateTimeChecker.checkAll(LocalDateTime.of(LocalDate.now(), startTime), LocalDateTime.of(LocalDate.now(), endTime))

        then:
        RESULT == result

        where:
        DESC                         | START               | END                  | RESULT
        "start의 minute이 정해진 값이 아닐 때" | LocalTime.of(0, 15) | LocalTime.of(1, 0)   | false
        "end의 minute이 정해진 값이 아닐 때"   | LocalTime.of(0, 0)  | LocalTime.of(1, 20)  | false
        "정상적인 range가 아닐 때"           | LocalTime.of(5, 0)  | LocalTime.of(4, 0)   | false
        "정상일 때"                      | LocalTime.of(10, 0) | LocalTime.of(23, 30) | true
    }
}
