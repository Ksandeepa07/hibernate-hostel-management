package lk.ijse.hostel_management.service.custom;

import lk.ijse.hostel_management.dto.RoomDTO;
import lk.ijse.hostel_management.service.SuperService;

import java.util.List;

public interface HomeService  extends SuperService {
    List<RoomDTO> getAllRooms();
    int countStudentIds();

    int countRoomIds();

    int countResIds();
}
