package lk.ijse.hostel_management.service.custom;

import lk.ijse.hostel_management.service.SuperService;

import java.util.List;

public interface PendingPaymentsService<T> extends SuperService {
    List<T> getAllPendingPayments();
}
