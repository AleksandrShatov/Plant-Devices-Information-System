package dao;

import dto.IUser;

import java.util.List;

public interface IUserDao extends IGenericDao<IUser, IUser> {
    IUser getById(Integer userId);
    List<IUser> getAll();
    boolean create(IUser whoCreate, IUser newUser);
    boolean update(IUser whoUpdate, IUser userForUpdate);
    boolean delete(IUser whoDelete, Integer userId);
}