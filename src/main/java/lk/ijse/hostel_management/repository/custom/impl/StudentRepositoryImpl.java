package lk.ijse.hostel_management.repository.custom.impl;

import lk.ijse.hostel_management.entity.Student;
import lk.ijse.hostel_management.repository.custom.StudentRepository;
import org.hibernate.Session;

import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private Session session;
    @Override
    public String save(Student student) {
        return  (String) session.save(student);

    }

    @Override
    public boolean update(Student student) {
        return false;
    }

    @Override
    public boolean delete(Student student) {
        return false;
    }

    @Override
    public List<Student> getAll() {
        List<Student> studentList=session.createQuery("FROM Student", Student.class).getResultList();
        return studentList;
    }

    @Override
    public Student searchById(Integer id) {
        return null;
    }

    @Override
    public Student searchIdByString(String id) {
        return null;
    }

    @Override
    public void setSession(Session session) {
        this.session=session;

    }
}
