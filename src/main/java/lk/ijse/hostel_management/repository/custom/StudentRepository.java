package lk.ijse.hostel_management.repository.custom;

import lk.ijse.hostel_management.entity.Student;
import lk.ijse.hostel_management.repository.CrudRepository;
import org.hibernate.Session;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,String,Integer> {
    void setSession(Session session);
    List<String> loadStudentIds();
    int countIds();
}
