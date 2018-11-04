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

	private String userName;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "reservation_id")
	private List<ReservationCell> reservationCellList;

	public static Reservation of(String title, String userName, List<ReservationCell> reservationCellList) {
        Reservation reservation = new Reservation();
        reservation.setTitle(title);
        reservation.setUserName(userName);
        reservation.setReservationCellList(reservationCellList);
        return reservation;
    }
}
