package com.ilsee.schedulemanager.controller.api.room;

import com.ilsee.schedulemanager.domain.room.RoomService;
import com.ilsee.schedulemanager.domain.support.utils.ModelUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/room")
@RestController
@RequiredArgsConstructor
public class RoomApiController {
    private final RoomService roomService;

    @GetMapping("list")
    public List<RoomDto> listAllRooms() {
        List<RoomDto> convert = ModelUtils.convert(roomService.getAllRooms(), RoomDto.class);
        return convert;
    }
}
