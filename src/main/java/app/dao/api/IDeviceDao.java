package app.dao.api;

import app.dto.device.api.IDevice;
import app.dto.user.api.IUser;

import java.util.List;

public interface IDeviceDao {
    IDevice getById(Integer deviceId);
    List<IDevice> getAll();
    boolean create(IUser whoCreate, IDevice newDevice);
    boolean update(IUser whoUpdate, IDevice deviceForUpdate);
    boolean delete(IUser whoDelete, Integer deviceId);
}
