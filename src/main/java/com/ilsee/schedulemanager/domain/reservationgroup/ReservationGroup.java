package com.ilsee.schedulemanager.domain.reservationgroup;

import com.ilsee.schedulemanager.domain.reservation.Reservation;
import com.ilsee.schedulemanager.domain.support.entity.CreateModifyEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "reservation_groups")
@ToString
@EqualsAndHashCode(of = "id", callSuper = true)
public class ReservationGroup extends CreateModifyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer repeatCount;

    @OneToMany
    @JoinColumn(name = "reservation_group_id")
    private Set<Reservation> reservationList;
}
