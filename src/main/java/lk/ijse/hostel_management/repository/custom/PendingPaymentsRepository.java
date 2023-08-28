package lk.ijse.hostel_management.repository.custom;

import lk.ijse.hostel_management.Projection.CustomeProjection;
import lk.ijse.hostel_management.repository.CrudRepository;
import org.hibernate.Session;

import java.util.List;

public interface PendingPaymentsRepository extends CrudRepository<CustomeProjection,String,Integer> {
    List<CustomeProjection> getAllPendingPayments();
    void setSession(Session session);
}
