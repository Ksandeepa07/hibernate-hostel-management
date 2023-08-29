package lk.ijse.hostel_management.service;

import lk.ijse.hostel_management.service.custom.impl.*;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory(){

    }

    public static ServiceFactory getInstance(){
        return (null==serviceFactory)?
                serviceFactory=new ServiceFactory()
                :serviceFactory;
    }

    public enum serviceTypes{
        Room,user,student,reservation,pendingPayments,home,login,updatePw

    }
    public <T extends SuperService>T getService(serviceTypes serviceTypes){
        switch (serviceTypes){
            case Room:
                return (T)new RoomServiceImpl();

            case user:
                return (T)new UserServiceImpl();

            case student:
                return (T)new StudentServiceImpl();

            case reservation:
                return (T)new ReservationServiceImpl();

            case pendingPayments:
                return (T)new PendingPaymentsServiceImpl();

            case home:
                return (T)new HomeServiceImpl();

            case login:
                return(T)new LoginServiceImpl();

            case updatePw:
                return (T)new UpadtePwServiceImpl();


            default:
                return null;
        }

    }
}
