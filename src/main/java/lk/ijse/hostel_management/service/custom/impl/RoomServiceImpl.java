package lk.ijse.hostel_management.service.custom.impl;

import lk.ijse.hostel_management.config.SessionFactoryConfig;
import lk.ijse.hostel_management.dto.RoomDTO;
import lk.ijse.hostel_management.entity.Room;
import lk.ijse.hostel_management.repository.RepositoryFactory;
import lk.ijse.hostel_management.repository.custom.RoomRepository;
import lk.ijse.hostel_management.service.custom.RoomService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class RoomServiceImpl implements RoomService<RoomDTO, String> {
    RoomRepository repository = RepositoryFactory.getInstance().getRepostory(RepositoryFactory.repositoryTypes.room);

    @Override
    public boolean saveRoom(RoomDTO roomDTO) {
        Session session= SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try{
            repository.setSession(session);
            boolean saved=repository.save(new Room(
                    roomDTO.getRoomTypeId(),
                    roomDTO.getType(),
                    roomDTO.getKeyMoney(),
                    roomDTO.getQty(),
                    roomDTO.getAccomadation()
            ));
            transaction.commit();
            session.close();
            return saved;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            return false;

        }

    }

    @Override
    public boolean updateRoom(RoomDTO roomDTO) {
        Session session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        try{
            repository.setSession(session);
            boolean isUpadted=repository.update(new Room(roomDTO.getRoomTypeId()
                    , roomDTO.getType()
                    , roomDTO.getKeyMoney()
                    , roomDTO.getQty()
                    ,roomDTO.getAccomadation()
            ));

            transaction.commit();
            session.close();
            return isUpadted;

        }catch (Exception e){
            transaction.rollback();
            session.close();
            return false;
        }
    }

    @Override
    public boolean deleteRoom(RoomDTO roomDTO) {
        Session session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        try{
            repository.setSession(session);
           boolean isDeletd=repository.delete(new Room(roomDTO.getRoomTypeId()
                    , roomDTO.getType()
                    , roomDTO.getKeyMoney()
                    , roomDTO.getQty()
                   ,roomDTO.getAccomadation()
           ));

            transaction.commit();
            session.close();
            return isDeletd;

        }catch (Exception e){
            transaction.rollback();
            session.close();
            return false;

        }
    }

    @Override
    public List<RoomDTO> getAllRooms() {
        Session session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try{
            repository.setSession(session);
            List<Room> rooms=repository.getAll();
            List<RoomDTO> roomDTOS=new ArrayList<>();

            for (Room room : rooms) {
               roomDTOS.add(new RoomDTO(room.getRoomId()
                       ,room.getType()
                       ,room.getKeyMoney()
                       ,room.getQty()
                       ,room.getAccomadation()
               ));

            }
            transaction.commit();
            session.close();
            return roomDTOS;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            return null;

        }
    }
}
