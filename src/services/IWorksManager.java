package services;

import dto.*;

import java.time.LocalTime;
import java.util.List;

public interface IWorksManager {
    List<IWork> getByDeviceName(String deviceName);
    List<IWork> getByDeviceId(Integer id);
    List<IWork> getByTime(LocalTime startTime, LocalTime endTime);
    List<IWork> getByPlace(String place);
    List<IWork> getByLocationPosition(String locationPosition);
    boolean addDevice(IUser user, IWork work, IDevice device);
    boolean deleteDevice(IUser user, IWork work, IDevice device);

// boolean changePlace(IUser, IWork, String);
// boolean changeLocationPosition(IUser, IWork, String);
// boolean changeDescription(IUser, IWork, String);
// boolean changeStartTime(IUser, IWork, LocalTime);
// boolean changeFinishTime(IUser, IWork, LocalTime);

}
