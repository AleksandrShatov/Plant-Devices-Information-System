package dataForTesting;

import dto.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, содержащий стартовый набор устройств для тестирования
 */
public class DataDevicesTest {

    private static DataDevicesTest instance;

    private List<IDevice> devices;

    private DataDevicesTest() {
        this.devices = new ArrayList<>();
        devices.add(new SimpleDevice(1, "ВБИ-Б22-45У-1113-З", "индуктивный датчик", "КИП", "СЕНСОР"));
        devices.add(new SimpleDevice(2, "ВБИ-М08-45Р-1111-З", "индуктивный датчик", "КИП", "СЕНСОР"));
        devices.add(new SimpleDevice(3, "7302BETNG XA", "шариковый подшипник", "МЕХАНИКА", "ABB"));
        devices.add(new SimpleDevice(4, "R88M-1L1K030C-BS2", "асинхронный двигатель", "ЭЛЕКТРИКА", "OMRON"));
    }

    public List<IDevice> getDevices() {
        return devices;
    }

    public static DataDevicesTest getInstance() {
        if(instance == null) {
            instance = new DataDevicesTest();
        } else {
            throw new IllegalArgumentException("Объект DataDevicesTest уже создан!");
        }
        return instance;
    }
}
