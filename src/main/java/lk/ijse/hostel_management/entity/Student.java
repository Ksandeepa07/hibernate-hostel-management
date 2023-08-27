package lk.ijse.hostel_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "student_id")
    private String studentId;

    @Column(name = "name")
    private String studentName;

    @Lob
    @Column(name = "address")
    private String address;

    @Column(name = "contact")
    private String contact;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "gender")
    private String gender;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "studentId")
    private List<Reservation> reservationList=new ArrayList<>();

    public Student(String studentId, String studentName, String address, String contact, LocalDate dob, String gender) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.address = address;
        this.contact = contact;
        this.dob = dob;
        this.gender = gender;
    }
}
