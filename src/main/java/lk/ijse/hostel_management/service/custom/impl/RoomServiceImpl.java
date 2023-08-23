package lk.ijse.hostel_management.service.custom.impl;

import lk.ijse.hostel_management.config.SessionFactoryConfig;
import lk.ijse.hostel_management.dto.RoomDTO;
import lk.ijse.hostel_management.entity.Room;
import lk.ijse.hostel_management.repository.RepositoryFactory;
import lk.ijse.hostel_management.repository.custom.RoomRepository;
import lk.ijse.hostel_management.service.custom.RoomService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class RoomServiceImpl implements RoomService<RoomDTO, String> {
    RoomRepository repository = RepositoryFactory.getInstance().getRepostory(RepositoryFactory.repositoryTypes.room);

    @Override
    public String saveRoom(RoomDTO roomDTO) {
        Session session= SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try{
            repository.setSession(session);
            String saved=repository.save(new Room(roomDTO.getRoomTypeId()
                    , roomDTO.getType()
                    , roomDTO.getKeyMoney()
                    , roomDTO.getQty()));
            transaction.commit();
            session.close();
            return saved;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            return null;

        }

    }

    @Override
    public boolean updateRoom(RoomDTO roomDTO) {
        return false;
    }

    @Override
    public boolean deleteRoom(RoomDTO roomDTO) {
        return false;
    }

    @Override
    public ArrayList<RoomDTO> getAllRooms() {
        return null;
    }
}
