package dao;

import dto.IDevice;
import dto.IUser;

import java.util.List;

public interface IDeviceDao {
    IDevice getById(Integer deviceId);
    List<IDevice> getAll();
    boolean create(IUser whoCreate, IDevice newDevice);
    boolean update(IUser whoUpdate, IDevice deviceForUpdate);
    boolean delete(IUser whoDelete, Integer deviceId);
}
