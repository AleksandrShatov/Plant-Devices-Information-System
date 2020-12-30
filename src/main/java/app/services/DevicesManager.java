package app.services;

import app.dao.DeviceDao;
import app.dto.device.api.IDevice;
import app.services.api.IDevicesManager;

import java.util.ArrayList;
import java.util.List;

public class DevicesManager implements IDevicesManager {

    private static DevicesManager instance;

    private DeviceDao deviceDao;

    private DevicesManager(DeviceDao deviceDao) {
        this.deviceDao = deviceDao;
    }

    @Override
    public List<IDevice> getByName(String name) {
        List<IDevice> devicesResult = new ArrayList<>();
        for (IDevice device : deviceDao.getAll()) {
            if(device.getName().contains(name)) {
                devicesResult.add(device);
            }
        }
        return devicesResult;
    }

    @Override
    public List<IDevice> getByType(String type) {
        List<IDevice> devicesResult = new ArrayList<>();
        for (IDevice device : deviceDao.getAll()) {
            if(device.getType().contains(type)) {
                devicesResult.add(device);
            }
        }
        return devicesResult;
    }

    @Override
    public List<IDevice> getByManufacturer(String manufacturer) {
        List<IDevice> devicesResult = new ArrayList<>();
        for (IDevice device : deviceDao.getAll()) {
            if(device.getManufacturer().contains(manufacturer)) {
                devicesResult.add(device);
            }
        }
        return devicesResult;
    }

    @Override
    public List<IDevice> getByCategory(String category) {
        List<IDevice> devicesResult = new ArrayList<>();
        for (IDevice device : deviceDao.getAll()) {
            if(device.getCategory().contains(category)) {
                devicesResult.add(device);
            }
        }
        return devicesResult;
    }

    public static DevicesManager getInstance(DeviceDao deviceDao) {
        if(instance == null) {
            instance = new DevicesManager(deviceDao);
        } else {
            throw new IllegalArgumentException("Объект DevicesManager уже создан!");
        }
        return instance;
    }
}
