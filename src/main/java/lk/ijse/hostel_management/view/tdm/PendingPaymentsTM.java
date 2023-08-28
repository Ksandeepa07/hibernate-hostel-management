package lk.ijse.hostel_management.view.tdm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PendingPaymentsTM {
    private String resId;
    private String studentId;
    private String name;
    private String contact;
}
