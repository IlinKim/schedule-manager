package com.ilsee.schedulemanager.domain.validator

import com.ilsee.schedulemanager.controller.api.reservation.ReservationRequestDto
import com.ilsee.schedulemanager.domain.exception.ValidationException
import org.springframework.validation.Errors
import spock.lang.Specification

import java.time.LocalDate
import java.time.LocalTime

class ReservationRequestDateValidatorTest extends Specification {

    def "ReservationRequestDto date validation이 fail일 경우"() {
        setup:
        ReservationRequestDateValidator validator = new ReservationRequestDateValidator()
        ReservationRequestDto reservationRequestDto = new ReservationRequestDto(date: LocalDate.now(), startTime: LocalTime.of(0, 15), endTime: LocalTime.now())

        when:
        validator.validate(reservationRequestDto, Mock(Errors))

        then:
        thrown(ValidationException)
    }


    def "ReservationRequestDto date validation이 success 일 경우"() {
        setup:
        ReservationRequestDateValidator validator = new ReservationRequestDateValidator()
        ReservationRequestDto reservationRequestDto = new ReservationRequestDto(date: LocalDate.now(), startTime: LocalTime.of(0, 30), endTime: LocalTime.of(3, 0))

        when:
        validator.validate(reservationRequestDto, Mock(Errors))

        then:
        noExceptionThrown()
    }
}
