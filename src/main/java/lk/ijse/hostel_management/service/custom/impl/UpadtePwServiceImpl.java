package lk.ijse.hostel_management.service.custom.impl;

import lk.ijse.hostel_management.config.SessionFactoryConfig;
import lk.ijse.hostel_management.dto.UserDTO;
import lk.ijse.hostel_management.entity.User;
import lk.ijse.hostel_management.repository.RepositoryFactory;
import lk.ijse.hostel_management.repository.custom.UserRepository;
import lk.ijse.hostel_management.service.custom.UpadtePwService;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UpadtePwServiceImpl implements UpadtePwService<UserDTO> {
    UserRepository userRepository = RepositoryFactory.getInstance().getRepostory(RepositoryFactory.repositoryTypes.user);

    @Override
    public boolean upadetePassword(UserDTO userDTO) {

        Session session= SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        try {
            userRepository.setSession(session);
            boolean isUpdated=userRepository.update(new User(
                    userDTO.getUserId(),
                    userDTO.getUserName(),
                    userDTO.getPassword()
            ));

            transaction.commit();
            session.close();
            return isUpdated;

        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            session.close();
            return false;
        }

    }
}
