package com.ilsee.schedulemanager.domain.timeline;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "time_lines")
@ToString
@EqualsAndHashCode(of = "id")
public class TimeLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime start;

    private LocalTime end;
}
