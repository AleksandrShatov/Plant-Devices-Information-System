package app.dto.maintenance.api;

import app.dto.device.api.IDevice;

import java.time.LocalTime;
import java.util.List;

public interface IWork {
    Integer getId();
    String getPlace();
    String getLocationPosition();
    List<IDevice> getDevices();
    String getDescription();
    LocalTime getStartTime();
    LocalTime getFinishTime();
    LocalTime getTotalTime();
    boolean addDevice(IDevice device);
    boolean deleteDevice(IDevice device); // TODO by Id
}
