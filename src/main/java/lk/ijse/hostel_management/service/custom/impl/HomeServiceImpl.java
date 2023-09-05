package lk.ijse.hostel_management.service.custom.impl;

import lk.ijse.hostel_management.config.SessionFactoryConfig;
import lk.ijse.hostel_management.dto.RoomDTO;
import lk.ijse.hostel_management.entity.Room;
import lk.ijse.hostel_management.repository.RepositoryFactory;
import lk.ijse.hostel_management.repository.custom.ReservationRepository;
import lk.ijse.hostel_management.repository.custom.RoomRepository;
import lk.ijse.hostel_management.repository.custom.StudentRepository;
import lk.ijse.hostel_management.service.custom.HomeService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class HomeServiceImpl implements HomeService {
    RoomRepository roomRepository= RepositoryFactory.getInstance().getRepostory(RepositoryFactory.repositoryTypes.room);
    StudentRepository studentRepository=RepositoryFactory.getInstance().getRepostory(RepositoryFactory.repositoryTypes.student);
    ReservationRepository reservationRepository=RepositoryFactory.getInstance().getRepostory(RepositoryFactory.repositoryTypes.reservation);
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
                        room.getQty(),
                        room.getAccomadation()
                ));

            }
            return roomDTOList;


        } catch (Exception e) {
            transaction.rollback();
            session.close();
            return null;

        }
    }

    @Override
    public int countStudentIds() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        try {
            studentRepository.setSession(session);
            int count=studentRepository.countIds();
            transaction.commit();
            session.close();
            return count;

        }catch (Exception e){
            transaction.rollback();
            session.close();
            return -1;
        }


    }

    @Override
    public int countRoomIds() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        try {
            roomRepository.setSession(session);
            int count=roomRepository.countIds();
            transaction.commit();
            session.close();
            return count;

        }catch (Exception e){
            transaction.rollback();
            session.close();
            return -1;
        }


    }

    @Override
    public int countResIds() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        try {
            reservationRepository.setSession(session);
            int count=reservationRepository.countIds();
            transaction.commit();
            session.close();
            return count;

        }catch (Exception e){
            transaction.rollback();
            session.close();
            return -1;
        }
    }

}
