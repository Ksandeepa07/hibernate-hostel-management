package lk.ijse.hostel_management.repository;

import lk.ijse.hostel_management.repository.custom.impl.*;

public class RepositoryFactory {

    private static RepositoryFactory repositoryFactory;

    private RepositoryFactory(){

    }

    public static RepositoryFactory getInstance(){
        return (null==repositoryFactory)?
                repositoryFactory=new RepositoryFactory()
                :repositoryFactory;
    }

    public enum repositoryTypes{
        room,user,student,reservation,pendingPayments

    }

    public <T extends SuperRepository>T getRepostory(repositoryTypes repositoryTypes){

        switch (repositoryTypes){
            case room:
                return (T)new RoomRepositoryimpl();

            case user:
                return (T)new UserRepositoryImpl();

            case student:
                return (T)new StudentRepositoryImpl();

            case reservation:
                return (T)new ReservationRepositoryImpl();

            case pendingPayments:
                return (T)new PendingPaymentsRepositoryImpl();


            default:
                return null;
        }

    }

}
