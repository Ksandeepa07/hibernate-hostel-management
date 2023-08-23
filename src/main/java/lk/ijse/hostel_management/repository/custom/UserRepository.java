package lk.ijse.hostel_management.repository.custom;

import lk.ijse.hostel_management.entity.User;
import lk.ijse.hostel_management.repository.CrudRepository;
import org.hibernate.Session;

public interface UserRepository extends CrudRepository<User,String,Integer> {
    void setSession(Session session);
}
