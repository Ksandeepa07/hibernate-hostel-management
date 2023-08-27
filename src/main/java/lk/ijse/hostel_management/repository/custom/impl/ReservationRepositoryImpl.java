package lk.ijse.hostel_management.repository.custom.impl;

import lk.ijse.hostel_management.entity.Reservation;
import lk.ijse.hostel_management.entity.Room;
import lk.ijse.hostel_management.repository.custom.ReservationRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class ReservationRepositoryImpl implements ReservationRepository {
    private Session session;
    @Override
    public boolean save(Reservation reservation) {
        System.out.println(reservation);

        try{
             session.save(reservation) ;
             return true;
        }catch (Exception e){

            return false;

        }

    }

    @Override
    public boolean update(Reservation reservation) {
        return false;
    }

    @Override
    public boolean delete(Reservation reservation) {
        session.delete(reservation);
        return true;
    }

    @Override
    public List<Reservation> getAll() {
        List<Reservation> reservations=session.createQuery("FROM Reservation ", Reservation.class).getResultList();
        return reservations;
    }

    @Override
    public Reservation searchById(Integer id) {
        return null;
    }

    @Override
    public Reservation searchIdByString(String id) {
        return null;
    }

    @Override
    public void setSession(Session session) {
        this.session=session;

    }

    @Override
    public Long countResId(String resId) {
        Query<Long> query = session.createQuery("SELECT COUNT(roomId.id) FROM Reservation r WHERE roomId.id = :resID", Long.class);
        query.setParameter("resID", resId);
        Long roomIdCOunt = query.uniqueResult();
        System.out.println(roomIdCOunt);
        return roomIdCOunt;
    }
}
