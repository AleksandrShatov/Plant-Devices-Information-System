package dao;

import java.util.Set;

public interface ICatalogDao<U, T> {
    boolean isContainValue(T entity);
    Set<T> getAll();
    boolean create(U creator, T entity);
    boolean update(U updater, T entity);
    boolean delete(U deleter, T entity);

}
