package app.dao.api;

import app.dto.user.api.IUser;
import app.dto.maintenance.api.IWork;

import java.util.List;

public interface IWorkDao {
    IWork getById(Integer workId);
    List<IWork> getALl();
    boolean create(IUser whoCreate, IWork newWork);
    boolean update(IUser whoUpdate, IWork workForUpdate);
    boolean delete(IUser whoDelete, int workId);
}
