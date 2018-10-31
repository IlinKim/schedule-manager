package com.ilsee.schedulemanager.domain.reservationcell;

import com.ilsee.schedulemanager.domain.room.Room;
import com.ilsee.schedulemanager.domain.support.entity.CreateModifyEntity;
import com.ilsee.schedulemanager.domain.timeline.TimeLine;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "reservation_cells")
@ToString
@EqualsAndHashCode(of = "id", callSuper = true)
public class ReservationCell extends CreateModifyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "room_id", nullable = false)
	private Room room;

	private LocalDate date;

	@ManyToOne
	@JoinColumn(name = "time_line_id", nullable = false)
	private TimeLine timeLine;
}
