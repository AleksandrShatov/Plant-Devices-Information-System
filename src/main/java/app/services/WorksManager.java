package app.services;

import app.dao.WorkDao;
import app.dto.device.api.IDevice;
import app.dto.user.api.IUser;
import app.dto.maintenance.api.IWork;
import app.services.api.IWorksManager;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class WorksManager implements IWorksManager {

    private static WorksManager instance;

    private WorkDao workDao;

    public WorksManager(WorkDao workDao) {
        this.workDao = workDao;
    }

    @Override
    public List<IWork> getByDeviceName(String deviceName) {
        List<IWork> worksResult = new ArrayList<>();
        for (IWork work : workDao.getALl()) {
            List<IDevice> devices = work.getDevices();
            for (IDevice device : devices) {
                if(device.getName().contains(deviceName)) {
                    worksResult.add(work);
                }
            }
        }
        return worksResult;
    }

    @Override
    public List<IWork> getByDeviceId(Integer deviceId) {
        List<IWork> worksResult = new ArrayList<>();
        for (IWork work : workDao.getALl()) {
            List<IDevice> devices = work.getDevices();
            for (IDevice device : devices) {
                if(device.getId() == deviceId.intValue()) {
                    worksResult.add(work);
                }
            }
        }
        return worksResult;
    }

    @Override
    public List<IWork> getByTime(LocalTime startTime, LocalTime endTime) {
        List<IWork> worksResult = new ArrayList<>();
        for (IWork work : workDao.getALl()) {
            int startHour = work.getStartTime().getHour();
            if (startHour >= startTime.getHour() && startHour <= endTime.getHour()) {
                worksResult.add(work);
            }
        }
        return worksResult;
    }

    @Override
    public List<IWork> getByPlace(String place) {
        List<IWork> worksResult = new ArrayList<>();
        for (IWork work : workDao.getALl()) {
            if(work.getPlace().contains(place)) {
                worksResult.add(work);
            }
        }
        return worksResult;
    }

    @Override
    public List<IWork> getByLocationPosition(String locationPosition) {
        List<IWork> worksResult = new ArrayList<>();
        for (IWork work : workDao.getALl()) {
            if(work.getLocationPosition().contains(locationPosition)) {
                worksResult.add(work);
            }
        }
        return worksResult;
    }

    @Override
    public boolean addDevice(IUser user, IWork work, IDevice device) {
        if(user.checkPermission("CAN_UPDATE_WORK")) {
            return work.addDevice(device);
        }
        return false;
    }

    @Override
    public boolean deleteDevice(IUser user, IWork work, IDevice device) {
        if(user.checkPermission("CAN_UPDATE_WORK")) {
            return work.deleteDevice(device);
        }
        return false;
    }

    public static WorksManager getInstance(WorkDao workDao) {
        if(instance == null) {
            instance = new WorksManager(workDao);
        } else {
            throw new IllegalArgumentException("Объект WorksManager уже создан!");
        }
        return instance;
    }
}
