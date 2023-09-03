package lk.ijse.hostel_management.service.custom;

import lk.ijse.hostel_management.service.SuperService;

import java.util.List;

public interface RoomService<T,ID> extends SuperService {
   boolean saveRoom(T t);
   boolean updateRoom(T t);
   boolean deleteRoom(T t);
   List<T> getAllRooms();
   T searchRoom(ID id);


}
