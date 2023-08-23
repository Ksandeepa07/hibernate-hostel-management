package lk.ijse.hostel_management.repository;

import lk.ijse.hostel_management.repository.custom.impl.RoomRepositoryimpl;

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
        room

    }

    public <T extends SuperRepository>T getRepostory(repositoryTypes repositoryTypes){

        switch (repositoryTypes){
            case room:
                return (T)new RoomRepositoryimpl();

            default:
                return null;
        }

    }

}
