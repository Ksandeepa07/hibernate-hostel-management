package lk.ijse.hostel_management.service.custom.impl;

import lk.ijse.hostel_management.config.SessionFactoryConfig;
import lk.ijse.hostel_management.dto.UserDTO;
import lk.ijse.hostel_management.entity.User;
import lk.ijse.hostel_management.repository.RepositoryFactory;
import lk.ijse.hostel_management.repository.custom.UserRepository;
import lk.ijse.hostel_management.service.custom.LoginService;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoginServiceImpl implements LoginService<UserDTO,String> {

    UserRepository userRepository= RepositoryFactory.getInstance().getRepostory(RepositoryFactory.repositoryTypes.user);
    @Override
    public UserDTO searchUser(String id) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            userRepository.setSession(session);
            User user = userRepository.searchIdByString(id);
            transaction.commit();
            session.close();
            return new UserDTO(user.getUserId()
                    , user.getUserName()
                    , user.getPassword());

        } catch (Exception e) {

            if (transaction==null ){
                transaction.rollback();
            }
            System.out.println(e);

            session.close();
            return null;

        }
    }
}
