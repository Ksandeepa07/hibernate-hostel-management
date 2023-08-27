package lk.ijse.hostel_management.repository.custom.impl;

import lk.ijse.hostel_management.entity.Student;
import lk.ijse.hostel_management.entity.User;
import lk.ijse.hostel_management.repository.custom.UserRepository;
import org.hibernate.Session;

import javax.persistence.Id;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private Session session;

    @Override
    public boolean save(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User searchById(Integer id) {
        User user=session.get(User.class,id);
        return user;
    }

    @Override
    public User searchIdByString(String s) {
        return null;
    }


    @Override
    public void setSession(Session session) {
        this.session=session;


    }
}
