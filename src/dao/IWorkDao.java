package dao;

import dto.IUser;
import dto.IWork;

import java.util.List;

public interface IWorkDao {
    IWork getById(Integer workId);
    List<IWork> getALl();
    boolean create(IUser whoCreate, IWork newWork);
    boolean update(IUser whoUpdate, IWork workForUpdate);
    boolean delete(IUser whoDelete, int workId);
}
