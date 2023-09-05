package lk.ijse.hostel_management.repository.custom;

import lk.ijse.hostel_management.entity.Reservation;
import lk.ijse.hostel_management.entity.Room;
import lk.ijse.hostel_management.repository.CrudRepository;
import org.hibernate.Session;

public interface ReservationRepository extends CrudRepository<Reservation,String,Integer> {
    void setSession(Session session);
    Long countResId(String resId);
    String generateNextResevationId();
    int countIds();
}
