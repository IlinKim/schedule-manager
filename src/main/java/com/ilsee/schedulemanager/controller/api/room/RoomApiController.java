package com.ilsee.schedulemanager.controller.api.room;

import com.ilsee.schedulemanager.domain.exception.ValidationErrors;
import com.ilsee.schedulemanager.domain.exception.ValidationException;
import com.ilsee.schedulemanager.domain.room.Room;
import com.ilsee.schedulemanager.domain.room.RoomService;
import com.ilsee.schedulemanager.domain.support.utils.ModelUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.function.Function;

@RequestMapping("/api/room")
@RestController
@RequiredArgsConstructor
public class RoomApiController {
    private static final Function<RoomRequestDto, Room> converter = dto -> {
        Room room = new Room();
        room.setRoomName(dto.getRoomName());
        room.setRoomColor(dto.getRoomColor());
        return room;
    };

    private final RoomService roomService;


    @GetMapping("list")
    public List<RoomResponseDto> listAllRooms() {
        return ModelUtils.convert(roomService.getAllRooms(), RoomResponseDto.class);
    }

    @PostMapping("save")
    public void saveRoom(@Valid @RequestBody RoomRequestDto roomResponseDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(ValidationErrors.COMMON);
        }
        roomService.save(converter.apply(roomResponseDto));
    }
}
