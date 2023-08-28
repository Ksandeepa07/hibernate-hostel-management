package lk.ijse.hostel_management.repository.custom.impl;

import lk.ijse.hostel_management.entity.Student;
import lk.ijse.hostel_management.repository.custom.StudentRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private Session session;
    @Override
    public boolean save(Student student) {
        session.save(student);
        return true;

    }

    @Override
    public boolean update(Student student) {
        session.update(student);
        return true;
    }

    @Override
    public boolean delete(Student student) {
        session.delete(student);
        return true;
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

    @Override
    public List<String> loadStudentIds() {
        Query<String> query=session.createQuery("SELECT s.id FROM Student s", String.class);
        List<String> list=query.getResultList();
        System.out.println(list);
        return list;
    }
}
