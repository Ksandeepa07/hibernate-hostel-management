package lk.ijse.hostel_management.repository.custom.impl;

import lk.ijse.hostel_management.entity.Room;
import lk.ijse.hostel_management.entity.User;
import lk.ijse.hostel_management.repository.custom.RoomRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class RoomRepositoryimpl implements RoomRepository {
    private Session session;
    @Override
    public boolean save(Room room) {
        try{
             session.save(room);
             return true;
        }catch (Exception e){
            e.printStackTrace();

        }
        return false;

    }

    @Override
    public boolean update(Room room) {
        session.merge(room);
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
    public Room searchIdByString(String id) {
        Room room=session.get(Room.class,id);
        return room;
    }


    @Override
    public void setSession(Session session) {
        this.session=session;

    }

    @Override
    public List<String> loadRoomTypeIds() {
       Query<String> query= session.createQuery("SELECT r.id FROM Room r", String.class);
       List<String> list=query.getResultList();
       return list;
    }

    @Override
    public int countIds() {
        Query<Long> query = session.createQuery("SELECT COUNT (r.roomId) from Room as r",Long.class);
        Long count=query.uniqueResult();
        int newCount= Math.toIntExact(count);
        System.out.println(count);
        return newCount;
    }
}
