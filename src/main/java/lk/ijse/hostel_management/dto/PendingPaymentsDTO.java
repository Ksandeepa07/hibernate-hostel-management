package lk.ijse.hostel_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PendingPaymentsDTO {
    private String resId;
    private String studentId;
    private String name;
    private String contact;
}
