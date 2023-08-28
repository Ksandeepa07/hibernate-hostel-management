package lk.ijse.hostel_management.service.custom.impl;

import lk.ijse.hostel_management.config.SessionFactoryConfig;
import lk.ijse.hostel_management.dto.RoomDTO;
import lk.ijse.hostel_management.entity.Room;
import lk.ijse.hostel_management.repository.RepositoryFactory;
import lk.ijse.hostel_management.repository.custom.RoomRepository;
import lk.ijse.hostel_management.service.custom.HomeService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class HomeServiceImpl implements HomeService {
    RoomRepository roomRepository= RepositoryFactory.getInstance().getRepostory(RepositoryFactory.repositoryTypes.room);
    @Override
    public List<RoomDTO> getAllRooms() {

        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            roomRepository.setSession(session);
            List<Room> list = roomRepository.getAll();
            List<RoomDTO> roomDTOList = new ArrayList<>();
            for (Room room : list) {
                roomDTOList.add(new RoomDTO(
                        room.getRoomId(),
                        room.getType(),
                        room.getKeyMoney(),
                        room.getQty()
                ));

            }
            return roomDTOList;


        } catch (Exception e) {
            transaction.rollback();
            session.close();
            return null;

        }
    }

}
