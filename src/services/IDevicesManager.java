package services;

import dto.IDevice;

import java.util.List;

public interface IDevicesManager {
    List<IDevice> getByName(String name);
    List<IDevice> getByType(String type);
    List<IDevice> getByManufacturer(String manufacturer);
    List<IDevice> getByCategory(String category);

// boolean changeUserLogin(IUser, IDevice, String);
// boolean changeUserPassword(IUser, IDevice, String);
// boolean changeUserName(IUser, IDevice, String);
// boolean changeUserRole(IUser, IDevice, RoleEnum);

}
