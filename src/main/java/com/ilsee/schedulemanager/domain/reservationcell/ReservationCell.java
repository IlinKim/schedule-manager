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
@Table(name = "reservation_cells", uniqueConstraints = @UniqueConstraint(name = "reservation_cell_uk_01", columnNames = { "room_id", "date",
	"time_line_id" }))
@ToString
@EqualsAndHashCode(of = { "room", "date", "timeLine" }, callSuper = true)
public class ReservationCell extends CreateModifyEntity implements Comparable<ReservationCell> {
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

	public static ReservationCell of(Room room, LocalDate date, TimeLine timeLine) {
		ReservationCell cell = new ReservationCell();
		cell.setRoom(room);
		cell.setDate(date);
		cell.setTimeLine(timeLine);
		return cell;
	}

	@Override
	public int compareTo(ReservationCell o) {
		return this.getTimeLine().getStart().compareTo(o.getTimeLine().getStart());
	}
}
