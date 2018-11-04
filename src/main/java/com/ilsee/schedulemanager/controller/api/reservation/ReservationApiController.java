package com.ilsee.schedulemanager.controller.api.reservation;

import com.ilsee.schedulemanager.controller.converter.ReservationGroupConverter;
import com.ilsee.schedulemanager.controller.converter.ReservationResponseDtoConverter;
import com.ilsee.schedulemanager.domain.exception.ValidationErrors;
import com.ilsee.schedulemanager.domain.exception.ValidationException;
import com.ilsee.schedulemanager.domain.reservationgroup.ReservationGroup;
import com.ilsee.schedulemanager.domain.reservationgroup.ReservationGroupService;
import com.ilsee.schedulemanager.domain.validator.ReservationRequestDateValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequestMapping("/api/reservation")
@RestController
@RequiredArgsConstructor
public class ReservationApiController {
    private final ReservationGroupService reservationGroupService;
    private final ReservationResponseDtoConverter reservationResponseDtoConverter;
    private final ReservationGroupConverter reservationGroupConverter;
    private final ReservationRequestDateValidator reservationRequestDateValidator;

    @GetMapping("list")
    public List<ReservationResponseDto> listAllReservations(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        List<ReservationGroup> allReservationGroups = reservationGroupService.getAllReservationGroups(start.toLocalDate(), end.toLocalDate());
        List<ReservationResponseDto> collect = allReservationGroups.stream()
                .map(reservationResponseDtoConverter)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return collect;
    }

    @PostMapping("save")
    public void saveReservation(@Valid @RequestBody ReservationRequestDto reservationRequestDto, BindingResult bindingResult) {
        log.info("############ save!!! {}", reservationRequestDto);
        if (bindingResult.hasErrors()) {
            throw new ValidationException(ValidationErrors.COMMON);
        }
        reservationGroupService.saveReservation(reservationGroupConverter.apply(reservationRequestDto));
    }

    @InitBinder("reservationRequestDto")
    public void setupBinder(WebDataBinder binder) {
        binder.addValidators(reservationRequestDateValidator);
    }

}
