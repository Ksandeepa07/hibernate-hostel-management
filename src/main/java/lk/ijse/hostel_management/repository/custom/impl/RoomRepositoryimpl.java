package lk.ijse.hostel_management.repository.custom.impl;

import lk.ijse.hostel_management.entity.Room;
import lk.ijse.hostel_management.repository.custom.RoomRepository;
import org.hibernate.Session;

import java.util.ArrayList;

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
        return false;
    }

    @Override
    public boolean delete(Room room) {
        return false;
    }

    @Override
    public ArrayList<Room> getAll() {
        return null;
    }

    @Override
    public void setSession(Session session) {
        this.session=session;

    }
}
