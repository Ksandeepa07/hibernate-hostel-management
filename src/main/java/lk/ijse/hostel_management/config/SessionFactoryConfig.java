package lk.ijse.hostel_management.config;

import lk.ijse.hostel_management.entity.Reservation;
import lk.ijse.hostel_management.entity.Room;
import lk.ijse.hostel_management.entity.Student;
import lk.ijse.hostel_management.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class SessionFactoryConfig {
    private static SessionFactoryConfig sessionFactoryConfig;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfig(){
        Configuration configuration=new Configuration();
        Properties properties = new Properties();
        try{
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
            System.out.println("yes");
        }catch (Exception e){
            System.out.println("cannot load properties file.");
        }
              sessionFactory=configuration.setProperties(properties)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Room.class)
                .addAnnotatedClass(Reservation.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance(){
        return (null==sessionFactoryConfig)?
                sessionFactoryConfig=new SessionFactoryConfig()
                :sessionFactoryConfig;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }


}
