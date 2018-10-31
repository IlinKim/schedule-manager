package com.ilsee.schedulemanager.controller.api;

import com.ilsee.schedulemanager.domain.room.Room;
import com.ilsee.schedulemanager.domain.room.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/reservation")
@RestController
@RequiredArgsConstructor
public class ReservationApiController {
    private final RoomRepository roomRepository;

    @RequestMapping("test")
    public List<String> test() {
        List<String> collect = roomRepository.findAll().stream().map(Room::getRoomName).collect(Collectors.toList());
        return collect;
    }
}
