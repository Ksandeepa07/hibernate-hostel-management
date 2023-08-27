package lk.ijse.hostel_management.entity;

import lk.ijse.hostel_management.dto.ReservationDTO;
import lk.ijse.hostel_management.embedded.ReservationPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    @Id
    @Column(name = "res_id")
    private String reservationId;

    @EmbeddedId
    private ReservationPK reservationPK;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "student_id",insertable = false,updatable = false)
    private Student studentId;

    @ManyToOne
    @JoinColumn(name = "room_type_id",insertable = false,updatable = false)
    private Room roomId;

    @Column(name = "status")
    private String status;


    public Reservation(String resId, LocalDate now, ReservationPK reservationPK, String status) {
        this.reservationId=resId;
        this.reservationPK=reservationPK;
        this.date=now;
        this.status=status;
    }
}
