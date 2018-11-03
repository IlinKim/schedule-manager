package com.ilsee.schedulemanager.domain.room;

import com.ilsee.schedulemanager.domain.support.entity.CreateModifyEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "rooms")
@ToString
@EqualsAndHashCode(of = "id", callSuper = true)
public class Room extends CreateModifyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomName;

    private String roomColor;

}
