package menu;

import dao.*;
import services.IDevicesManager;
import services.IMaintenancesManager;
import services.IUsersManager;
import services.IWorksManager;

public interface IMenu {

    int show();

    void setTypesDao(ICatalogDao typesDao);
    ICatalogDao getTypesDao();

    void setCategoriesDao(ICatalogDao categoriesDao);
    ICatalogDao getCategoriesDao();

    void setManufacturesDao(ICatalogDao manufacturesDao);
    ICatalogDao getManufacturesDao();

    void setPlacesDao(ICatalogDao placesDao);
    ICatalogDao getPlacesDao();

    void setLocationPositionsDao(ICatalogDao locationPositionsDao);
    ICatalogDao getLocationPositionsDao();

    void setUserDao(IUserDao userDao);
    IUserDao getUserDao();

    void setUsersManager(IUsersManager usersManager);
    IUsersManager getUsersManager();

    void setDeviceDao(IDeviceDao deviceDao);
    IDeviceDao getDeviceDao();

    void setDevicesManager(IDevicesManager devicesManager);
    IDevicesManager getDevicesManager();

    void setWorkDao(IWorkDao workDao);
    IWorkDao getWorkDao();

    void setWorksManager(IWorksManager worksManager);
    IWorksManager setWorksManager();

    void setMaintenanceDao(IMaintenanceDao maintenanceDao);
    IMaintenanceDao getMaintenanceDao();

    void setMaintenancesManager(IMaintenancesManager maintenancesManager);
    IMaintenancesManager getMaintenancesManager();
}
