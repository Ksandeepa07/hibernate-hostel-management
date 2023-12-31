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
    public boolean saveUser(UserDTO userDTO) {

        Session session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        try {
            userRepository.setSession(session);
            boolean isSaved=userRepository.save(new User(
                    userDTO.getUserId(),
                    userDTO.getUserName(),
                    userDTO.getPassword()
            ));

            transaction.commit();
            session.close();
            return isSaved;

        }catch (Exception e){
            transaction.rollback();
            session.close();
            return false;
        }

    }

}
