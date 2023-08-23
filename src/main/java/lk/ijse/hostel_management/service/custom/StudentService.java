package lk.ijse.hostel_management.service.custom;

import lk.ijse.hostel_management.service.SuperService;

import java.util.List;

public interface StudentService<T,Id,Idd> extends SuperService {
    String saveStudent(T t);
    boolean updateStudent(T t);
    boolean deleteStudent(T t);
    List<T> getAllStudents();
    T searchStudent(Id id);
}
