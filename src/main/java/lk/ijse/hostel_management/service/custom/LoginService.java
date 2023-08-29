package lk.ijse.hostel_management.service.custom;

import lk.ijse.hostel_management.service.SuperService;

public interface LoginService <T,Idd> extends SuperService {
    T searchUser(Idd id);
}
