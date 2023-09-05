package lk.ijse.hostel_management.repository.custom;

import lk.ijse.hostel_management.entity.Room;
import lk.ijse.hostel_management.repository.CrudRepository;
import org.hibernate.Session;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room,String,Integer> {
    void setSession(Session session);
    List<String> loadRoomTypeIds();
    int countIds();
}
