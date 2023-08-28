package lk.ijse.hostel_management.repository.custom.impl;

import lk.ijse.hostel_management.Projection.CustomeProjection;
import lk.ijse.hostel_management.entity.Student;
import lk.ijse.hostel_management.repository.custom.PendingPaymentsRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PendingPaymentsRepositoryImpl implements PendingPaymentsRepository {
    private Session session;
    @Override
    public boolean save(CustomeProjection customeProjection) {
        return false;
    }

    @Override
    public boolean update(CustomeProjection customeProjection) {
        return false;
    }

    @Override
    public boolean delete(CustomeProjection customeProjection) {
        return false;
    }

    @Override
    public List<CustomeProjection> getAll() {
        return null;
    }

    @Override
    public CustomeProjection searchById(Integer id) {
        return null;
    }

    @Override
    public CustomeProjection searchIdByString(String s) {
        return null;
    }


    @Override
    public List<CustomeProjection> getAllPendingPayments() {
        Query<CustomeProjection> query=session.createQuery("select new lk.ijse.hostel_management.Projection.CustomeProjection (" + " r.reservationId,s.studentId,s.studentName,s.contact) from Student s  join Reservation  r on s.studentId = r.studentId where r.status='not paid'");
        List<CustomeProjection> list=query.getResultList();
        System.out.println(list);
        return list;

    }

    @Override
    public void setSession(Session session) {
        this.session=session;
    }


}
