package lk.ijse.hostel_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "room")
public class Room {

    @Id
    @Column(name = "room_type_id")
    private String roomId;

    @Column(name = "type")
    private String type;

    @Column(name = "key_money")
    private String keyMoney;

    @Column(name = "qty")
    private int qty;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "roomId")
    private List<Reservation> reservationList=new ArrayList<>();


    public Room(String roomTypeId, String type, String keyMoney, Integer qty) {
        this.roomId=roomTypeId;
        this.type=type;
        this.keyMoney=keyMoney;
        this.qty=qty;
    }

    public Room(String roomId, int i) {
        this.roomId=roomId;
        this.qty=i;
    }
}
