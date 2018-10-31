package com.ilsee.schedulemanager.domain.timeline;

import com.ilsee.schedulemanager.domain.support.entity.CreateModifyEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "time_lines")
@ToString
@EqualsAndHashCode(of = "id", callSuper = true)
public class TimeLine extends CreateModifyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime start;

    private LocalTime end;
}
