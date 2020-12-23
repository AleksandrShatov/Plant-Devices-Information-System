package dao;

import java.util.List;

public interface IGenericDao<U, T> {
    T getById(Integer id);
    List<T> getAll();
    boolean create(U creator, T entity);
    boolean update(U updater, T entity);
    boolean delete(U deleter, Integer id);
}
