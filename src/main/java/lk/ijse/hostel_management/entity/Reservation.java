package lk.ijse.hostel_management.entity;

import lk.ijse.hostel_management.embedded.ReservationPK;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    @Id
    @Column(name = "res_id")
    private String reservationId;

    @EmbeddedId
    private ReservationPK reservationPK;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student studentId;

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private Room roomId;

    @Column(name = "status")
    private String status;

    public Reservation() {
    }

    public Reservation(String reservationId, ReservationPK reservationPK, Date date, Student studentId, Room roomId, String status) {
        this.reservationId = reservationId;
        this.reservationPK = reservationPK;
        this.date = date;
        this.studentId = studentId;
        this.roomId = roomId;
        this.status = status;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public ReservationPK getReservationPK() {
        return reservationPK;
    }

    public void setReservationPK(ReservationPK reservationPK) {
        this.reservationPK = reservationPK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", reservationPK=" + reservationPK +
                ", date=" + date +
                ", studentId=" + studentId +
                ", roomId=" + roomId +
                ", status='" + status + '\'' +
                '}';
    }
}
