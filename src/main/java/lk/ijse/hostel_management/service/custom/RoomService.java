package lk.ijse.hostel_management.service.custom;

import lk.ijse.hostel_management.service.SuperService;

import java.util.ArrayList;

public interface RoomService<T,ID> extends SuperService {
   String saveRoom(T t);
   boolean updateRoom(T t);
   boolean deleteRoom(T t);
   ArrayList<T> getAllRooms();


}
