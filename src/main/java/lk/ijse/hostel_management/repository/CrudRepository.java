package lk.ijse.hostel_management.repository;

import javax.persistence.Id;
import java.util.List;

public interface CrudRepository<T,ID,Idd> extends SuperRepository{

    boolean save(T t);
    boolean update(T t);
    boolean delete(T t);
    List<T> getAll();
    T searchById(Idd id);
    T searchIdByString(ID id);

}
