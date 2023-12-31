package lk.ijse.hostel_management.service.custom.impl;

import lk.ijse.hostel_management.config.SessionFactoryConfig;
import lk.ijse.hostel_management.dto.StudentDTO;
import lk.ijse.hostel_management.entity.Student;
import lk.ijse.hostel_management.repository.RepositoryFactory;
import lk.ijse.hostel_management.repository.custom.StudentRepository;
import lk.ijse.hostel_management.service.custom.StudentService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentServiceImpl implements StudentService<StudentDTO,String,Integer> {

    StudentRepository repository= RepositoryFactory.getInstance().getRepostory(RepositoryFactory.repositoryTypes.student);

    @Override
    public boolean saveStudent(StudentDTO studentDTO) {
        Session session= SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        try {
            repository.setSession(session);
            boolean isSaved=repository.save(new Student(
                    studentDTO.getStudentId(),
                    studentDTO.getName(),
                    studentDTO.getAddress(),
                    studentDTO.getConatct(),
                    LocalDate.parse(studentDTO.getDob()),
                    studentDTO.getGender()

            ));

            transaction.commit();
            session.close();
            return isSaved;

        }catch (Exception e){
            transaction.rollback();
            session.close();
            return false;

        }
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) {
        Session session= SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        try {
            repository.setSession(session);
            boolean isUpDated=repository.update(new Student(
                    studentDTO.getStudentId(),
                    studentDTO.getName(),
                    studentDTO.getAddress(),
                    studentDTO.getConatct(),
                    LocalDate.parse(studentDTO.getDob()),
                    studentDTO.getGender()

            ));

            transaction.commit();
            session.close();
            return isUpDated;

        }catch (Exception e){
            transaction.rollback();
            session.close();
            return false;

        }

    }

    @Override
    public boolean deleteStudent(StudentDTO studentDTO) {
        System.out.println(studentDTO);
        Session session= SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        try {
            repository.setSession(session);
            boolean isDeletd=repository.delete(new Student(
                    studentDTO.getStudentId(),
                    studentDTO.getName(),
                    studentDTO.getAddress(),
                    studentDTO.getConatct(),
                    LocalDate.parse(studentDTO.getDob()),
                    studentDTO.getGender()

            ));

            transaction.commit();
            session.close();
            return isDeletd;

        }catch (Exception e){
            transaction.rollback();
            session.close();
            return false;

        }
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        Session session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        try {
            repository.setSession(session);
            List<Student> studentList=repository.getAll();
            List<StudentDTO> studentDTOList=new ArrayList<>();
            for (Student student : studentList) {
                studentDTOList.add(new StudentDTO(
                        student.getStudentId(),
                        student.getStudentName(),
                        student.getAddress(),
                        student.getContact(),
                        student.getDob().toString(),
                        student.getGender()
                ));


            }

            transaction.commit();
            session.close();
            return studentDTOList;

        }catch (Exception e){
            transaction.rollback();
            session.close();
            return null;
        }
    }

    @Override
    public StudentDTO searchStudent(String id) {
       Session session=SessionFactoryConfig.getInstance().getSession();
       Transaction transaction=session.beginTransaction();

       try {
           repository.setSession(session);
           Student student=repository.searchIdByString(id);
           StudentDTO studentDTO=new StudentDTO(
                   student.getStudentId(),
                   student.getStudentName(),
                   student.getAddress(),
                   student.getContact(),
                   student.getDob().toString(),
                   student.getGender()
           );
           System.out.println(student);
           transaction.commit();
           session.close();
           return studentDTO;

       }catch (Exception e){
          transaction.rollback();
           session.close();
           return null;

       }
    }
}
