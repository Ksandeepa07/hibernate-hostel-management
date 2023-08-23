package lk.ijse.hostel_management.service.custom;

import lk.ijse.hostel_management.service.SuperService;

import java.util.List;

public interface UserService <T,Id,Idd>extends SuperService {
    String saveUser(T t);
    boolean updateRoom(T t);
    boolean deleteRoom(T t);
    List<T> getAllRooms();
    T searchUser(Idd id);
}
