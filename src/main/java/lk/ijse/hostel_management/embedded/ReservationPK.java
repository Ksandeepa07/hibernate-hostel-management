package lk.ijse.hostel_management.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ReservationPK implements Serializable {

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "room_type_id")
    private String roomId;

    public ReservationPK() {
    }

    public ReservationPK(String studentId, String roomId) {
        this.studentId = studentId;
        this.roomId = roomId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "ReservationPK{" +
                "studentId='" + studentId + '\'' +
                ", roomId='" + roomId + '\'' +
                '}';
    }
}
