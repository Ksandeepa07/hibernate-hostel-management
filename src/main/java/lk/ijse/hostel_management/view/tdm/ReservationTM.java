package lk.ijse.hostel_management.view.tdm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationTM {
    private String resId;
    private LocalDate date;
    private String studentId;
    private String roomId;
    private String status;
}
