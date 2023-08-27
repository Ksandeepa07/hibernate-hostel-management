package lk.ijse.hostel_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
    private String roomTypeId;
    private String type;
    private String keyMoney;
    private Integer qty;


}
