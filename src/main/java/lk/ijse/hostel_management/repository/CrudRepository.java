package lk.ijse.hostel_management.repository;

import java.util.ArrayList;

public interface CrudRepository<T,ID> extends SuperRepository{

    String save(T t);
    boolean update(T t);
    boolean delete(T t);
    ArrayList<T> getAll();

}
