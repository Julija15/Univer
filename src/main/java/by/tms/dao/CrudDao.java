package by.tms.dao;

import java.util.List;

public interface CrudDao<T,E>{
    T save (T entity);
    List<T> getList();
    T findById (E id);
}
