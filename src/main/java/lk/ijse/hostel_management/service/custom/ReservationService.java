package lk.ijse.hostel_management.service.custom;

import lk.ijse.hostel_management.service.SuperService;

import java.util.List;

public interface ReservationService<T,ID> extends SuperService {
    boolean saveReservation(T t);
    boolean updateReservation(T t);
    boolean deleteReservation(T t);
    List<T> getAllReservation();
    List<ID> loadStudentIds();
    List<ID> loadRoomTypeIds();
}
