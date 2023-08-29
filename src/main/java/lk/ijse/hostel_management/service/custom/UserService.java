package lk.ijse.hostel_management.service.custom;

import lk.ijse.hostel_management.service.SuperService;

import java.util.List;

public interface UserService <T,Id,Idd>extends SuperService {
    boolean saveUser(T t);

}
