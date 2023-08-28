package lk.ijse.hostel_management.service.custom.impl;

import lk.ijse.hostel_management.config.SessionFactoryConfig;
import lk.ijse.hostel_management.dto.ReservationDTO;
import lk.ijse.hostel_management.dto.RoomDTO;
import lk.ijse.hostel_management.embedded.ReservationPK;
import lk.ijse.hostel_management.entity.Reservation;
import lk.ijse.hostel_management.entity.Room;
import lk.ijse.hostel_management.entity.Student;
import lk.ijse.hostel_management.repository.RepositoryFactory;
import lk.ijse.hostel_management.repository.custom.ReservationRepository;
import lk.ijse.hostel_management.repository.custom.RoomRepository;
import lk.ijse.hostel_management.repository.custom.StudentRepository;
import lk.ijse.hostel_management.service.custom.ReservationService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationServiceImpl implements ReservationService <ReservationDTO,String>{

    ReservationRepository repository= RepositoryFactory.getInstance().getRepostory(RepositoryFactory.repositoryTypes.reservation);
    StudentRepository Studentrepository= RepositoryFactory.getInstance().getRepostory(RepositoryFactory.repositoryTypes.student);
    RoomRepository roomRepository = RepositoryFactory.getInstance().getRepostory(RepositoryFactory.repositoryTypes.room);

    @Override
    public boolean saveReservation(ReservationDTO reservationDTO) {
        Session session= SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
         try {
            repository.setSession(session);
             ReservationPK reservationPK=new ReservationPK(reservationDTO.getStudentId(),reservationDTO.getRoomId());

       boolean isSaved= repository.save(new Reservation(
                    reservationDTO.getResId(),
                    LocalDate.now(),
                    reservationPK,
                    reservationDTO.getStatus()
            ));

       if(isSaved){

           roomRepository.setSession(session);
           Long count=repository.countResId(reservationDTO.getRoomId());
           int newCount= (int) (count/5);
           Room room=roomRepository.searchIdByString(reservationDTO.getRoomId());
           if(count%room.getAccomadation()==0){


               roomRepository.update(new Room(
                       room.getRoomId(),
                       room.getType(),
                       room.getKeyMoney(),
                       room.getQty()-1,
                       room.getAccomadation()
               ));
           }




//           switch ((int) (count/5)){
//               case 2:
//                   roomRepository.update(new Room(
//                           reservationDTO.getRoomId(),
//                           10
//                   ));
//
//
//           }



           }
            transaction.commit();
            session.close();
             return isSaved;


        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            session.close();
            return false;

        }
    }

    @Override
    public boolean updateReservation(ReservationDTO reservationDTO) {
        Session session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        try{
            repository.setSession(session);
            ReservationPK reservationPK=new ReservationPK(reservationDTO.getStudentId(),reservationDTO.getRoomId());

            boolean isUpadted=repository.update(
                    new Reservation(
                            reservationDTO.getResId(),
                            LocalDate.now(),
                            reservationPK,
                            reservationDTO.getStatus()
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
    public boolean deleteReservation(ReservationDTO reservationDTO) {
        Session session= SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            repository.setSession(session);
            ReservationPK reservationPK=new ReservationPK(reservationDTO.getStudentId(),reservationDTO.getRoomId());

            boolean isDeletd= repository.delete(new Reservation(
                    reservationDTO.getResId(),
                    LocalDate.now(),
                    reservationPK,
                    reservationDTO.getStatus()
            ));

            if(isDeletd){
                roomRepository.setSession(session);
                Long count=repository.countResId(reservationDTO.getRoomId());
                int newCount= (int) (count/5);
                Room room=roomRepository.searchIdByString(reservationDTO.getRoomId());

                if(count%room.getAccomadation()==room.getAccomadation()-1){

                    roomRepository.update(new Room(
                            room.getRoomId(),
                            room.getType(),
                            room.getKeyMoney(),
                            room.getQty()+1,
                            room.getAccomadation()
                    ));
                }
//                else{
//                    Room room=roomRepository.searchIdByString(reservationDTO.getRoomId());
//
//                    roomRepository.update(new Room(
//                            room.getRoomId(),
//                            room.getType(),
//                            room.getKeyMoney(),
//                            room.getQty()+1
//                    ));
//
//                }




//           switch ((int) (count/5)){
//               case 2:
//                   roomRepository.update(new Room(
//                           reservationDTO.getRoomId(),
//                           10
//                   ));
//
//
//           }



            }
            transaction.commit();
            session.close();
            return isDeletd;


        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            session.close();
            return false;

        }
    }

    @Override
    public List<ReservationDTO> getAllReservation() {
        Session session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try{
            repository.setSession(session);
            List<Reservation> reservations=repository.getAll();
            List<ReservationDTO> list=new ArrayList<>();

            for (Reservation reservation : reservations) {
                list.add(new ReservationDTO(
                        reservation.getReservationId(),
                        reservation.getDate(),
                        reservation.getReservationPK().getStudentId(),
                        reservation.getReservationPK().getRoomId(),
                        reservation.getStatus()
                ));

            }
            transaction.commit();
            session.close();
            return list;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            return null;

        }
    }

    @Override
    public List<String> loadStudentIds() {
        Session session= SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        try {
            Studentrepository.setSession(session);
            List<String> list=Studentrepository.loadStudentIds();
            transaction.commit();
            session.close();
            return list;

        }catch (Exception e){
            transaction.rollback();
            session.close();
            return null;

        }

    }

    @Override
    public List<String> loadRoomTypeIds() {
        Session session= SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        try {
            roomRepository.setSession(session);
            List<String> list=roomRepository.loadRoomTypeIds();
            transaction.commit();
            session.close();
            return list;

        }catch (Exception e){
            transaction.rollback();
            session.close();
            return null;

        }
    }

    @Override
    public String generateNextResevationId() {
        Session session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        try {
            repository.setSession(session);
            String id=repository.generateNextResevationId();
            transaction.commit();
            session.close();
            return id;

        }catch (Exception e){
            transaction.rollback();
            session.close();
            return null;
        }
    }


}



