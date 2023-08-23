package lk.ijse.hostel_management.service.custom.impl;

import lk.ijse.hostel_management.config.SessionFactoryConfig;
import lk.ijse.hostel_management.dto.UserDTO;
import lk.ijse.hostel_management.entity.User;
import lk.ijse.hostel_management.repository.RepositoryFactory;
import lk.ijse.hostel_management.repository.custom.UserRepository;
import lk.ijse.hostel_management.service.custom.UserService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserServiceImpl implements UserService<UserDTO, String,Integer> {
    UserRepository userRepository = RepositoryFactory.getInstance().getRepostory(RepositoryFactory.repositoryTypes.user);

    @Override
    public String saveUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public boolean updateRoom(UserDTO userDTO) {
        return false;
    }

    @Override
    public boolean deleteRoom(UserDTO userDTO) {
        return false;
    }

    @Override
    public List<UserDTO> getAllRooms() {
        return null;
    }

    @Override
    public UserDTO searchUser(Integer id) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            userRepository.setSession(session);
            User user = userRepository.searchById(id);
            transaction.commit();
            session.close();
            return new UserDTO(user.getUserId()
                    , user.getUserName()
                    , user.getPassword());

        } catch (Exception e) {
            transaction.rollback();
            session.close();
            return null;

        }


    }
}
