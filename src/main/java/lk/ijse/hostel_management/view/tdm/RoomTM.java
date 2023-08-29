package lk.ijse.hostel_management.view.tdm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomTM {
    private String roomTypeId;
    private String type;
    private String keyMoney;
    private Integer qty;
    private Integer accomadations;


}
