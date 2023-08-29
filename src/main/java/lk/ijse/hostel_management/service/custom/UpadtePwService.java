package lk.ijse.hostel_management.service.custom;

import lk.ijse.hostel_management.service.SuperService;

public interface UpadtePwService <T> extends SuperService {
    boolean upadetePassword(T t);
}
