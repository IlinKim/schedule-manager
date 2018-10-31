package com.ilsee.schedulemanager.domain.reservation;

import com.ilsee.schedulemanager.domain.reservationcell.ReservationCell;
import com.ilsee.schedulemanager.domain.support.entity.CreateModifyEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "reservations")
@ToString
@EqualsAndHashCode(of = "id", callSuper = true)
public class Reservation extends CreateModifyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String description;

	private String userName;

	@OneToMany
	@JoinColumn(name = "reservation_id")
	private List<ReservationCell> reservationCellList;
}
