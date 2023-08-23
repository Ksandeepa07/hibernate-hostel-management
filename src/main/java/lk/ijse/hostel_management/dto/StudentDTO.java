package lk.ijse.hostel_management.dto;

import java.util.Date;

public class StudentDTO {
    private String studentId;
    private String name;
    private String address;
    private String conatct;
    private String dob;
    private String gender;

    public StudentDTO() {
    }

    public StudentDTO(String studentId, String name, String address, String conatct, String dob, String gender) {
        this.studentId = studentId;
        this.name = name;
        this.address = address;
        this.conatct = conatct;
        this.dob = dob;
        this.gender = gender;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getConatct() {
        return conatct;
    }

    public void setConatct(String conatct) {
        this.conatct = conatct;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", conatct='" + conatct + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
