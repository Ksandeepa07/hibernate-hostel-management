package lk.ijse.hostel_management.repository.custom;

import lk.ijse.hostel_management.entity.Room;
import lk.ijse.hostel_management.repository.CrudRepository;
import org.hibernate.Session;

public interface RoomRepository extends CrudRepository<Room,String> {
    void setSession(Session session);
}
