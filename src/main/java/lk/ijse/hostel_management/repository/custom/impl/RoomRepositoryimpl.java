package lk.ijse.hostel_management.repository.custom.impl;

import lk.ijse.hostel_management.entity.Room;
import lk.ijse.hostel_management.repository.custom.RoomRepository;
import org.hibernate.Session;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class RoomRepositoryimpl implements RoomRepository {
    private Session session;
    @Override
    public String save(Room room) {
        try{
            return (String) session.save(room);
        }catch (Exception e){
            e.printStackTrace();

        }
        return null;

    }

    @Override
    public boolean update(Room room) {
        session.update(room);
        return true;


    }

    @Override
    public boolean delete(Room room) {
        session.delete(room);
        return true;
    }

    @Override
    public List<Room> getAll() {
        try{
             List <Room> rooms=session.createQuery("FROM Room",Room.class).getResultList();
             return rooms;

        }catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public Room searchById(Integer id) {
        return null;
    }


    @Override
    public void setSession(Session session) {
        this.session=session;

    }
}
