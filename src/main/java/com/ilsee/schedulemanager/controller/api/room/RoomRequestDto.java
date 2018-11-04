package com.ilsee.schedulemanager.controller.api.room;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class RoomRequestDto {
    @NotEmpty
    private String roomName;
    @NotEmpty
    private String roomColor;
}
