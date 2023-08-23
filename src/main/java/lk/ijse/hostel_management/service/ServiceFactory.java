package lk.ijse.hostel_management.service;

import lk.ijse.hostel_management.service.custom.impl.RoomServiceImpl;
import lk.ijse.hostel_management.service.custom.impl.UserServiceImpl;

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
        Room,user

    }
    public <T extends SuperService>T getService(serviceTypes serviceTypes){
        switch (serviceTypes){
            case Room:
                return (T)new RoomServiceImpl();

            case user:
                return (T)new UserServiceImpl();

            default:
                return null;
        }

    }
}
