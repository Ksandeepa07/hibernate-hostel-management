package lk.ijse.hostel_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    private String resId;
    private LocalDate date;
    private String studentId;
    private String roomId;
    private String status;


}
