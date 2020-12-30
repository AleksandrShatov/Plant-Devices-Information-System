package app.dao;

import app.dao.api.IDeviceDao;
import app.dto.device.api.IDevice;
import app.dto.user.api.IUser;
import app.dto.device.SimpleDevice;

import java.util.*;

public class DeviceDao implements IDeviceDao {

    private static DeviceDao instance;

    private Map<Integer, IDevice> devices;

    private DeviceDao() {
        readDevices();
    }

    private boolean readDevices() { //TODO чтение из БД
        if(this.devices == null) {
            List<IDevice> devicesList = new ArrayList<>();
            devicesList.add(new SimpleDevice(1, "ВБИ-Б22-45У-1113-З", "индуктивный датчик", "КИП", "СЕНСОР"));
            devicesList.add(new SimpleDevice(2, "ВБИ-М08-45Р-1111-З", "индуктивный датчик", "КИП", "СЕНСОР"));
            devicesList.add(new SimpleDevice(3, "7302BETNG XA", "шариковый подшипник", "МЕХАНИКА", "ABB"));
            devicesList.add(new SimpleDevice(4, "R88M-1L1K030C-BS2", "асинхронный двигатель", "ЭЛЕКТРИКА", "OMRON"));
            this.devices = new HashMap<>();
            for (IDevice device : devicesList) {
                this.devices.put(device.getId(), device);
            }
            return true;
        }
        return false;
    }

    @Override
    public IDevice getById(Integer deviceId) {
        for (IDevice device : getAll()) {
            if(deviceId.intValue() == device.getId()) {
                return device;
            }
        }
        return null; // TODO
    }

    @Override
    public List<IDevice> getAll() {
        Set<Map.Entry<Integer, IDevice>> setOfDevices = this.devices.entrySet();
        List<IDevice> allDevices = new ArrayList<>();
        for (Map.Entry<Integer, IDevice> mapElement : setOfDevices) {
            IDevice device = mapElement.getValue();
            allDevices.add(device);
        }
        return allDevices;
    }

    @Override
    public boolean create(IUser whoCreate, IDevice newDevice) {
        if(whoCreate.checkPermission("CAN_CREATE_DEVICE")) {
            devices.put(devices.size(), newDevice);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(IUser whoUpdate, IDevice deviceForUpdate) {
        if(whoUpdate.checkPermission("CAN_UPDATE_DEVICE")) {

            return true;
        }
        return false;
    }

    @Override
    public boolean delete(IUser whoDelete, Integer deviceId) {
        if(whoDelete.checkPermission("CAN_DELETE_DEVICE")) {
            IDevice device = getById(deviceId);
            if(device != null) {
                return devices.remove(device.getId(), device);
            }
        }
        return false;
    }

    public static DeviceDao getInstance() {
        if(instance == null) {
            instance = new DeviceDao();
        } else {
            throw new IllegalArgumentException("Объект DeviceDao уже создан!");
        }
        return instance;
    }
}
