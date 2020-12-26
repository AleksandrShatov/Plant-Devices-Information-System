package menu;

import dao.*;
import dto.IUser;
import services.IDevicesManager;
import services.IMaintenancesManager;
import services.IUsersManager;
import services.IWorksManager;

public abstract class AbstractMenu implements IMenu {

    protected ICatalogDao<IUser, String> typesDao;
    protected ICatalogDao<IUser, String> categoriesDao;
    protected ICatalogDao<IUser, String> manufacturesDao;
    protected ICatalogDao<IUser, String> placesDao;
    protected ICatalogDao<IUser, String> locationPositionsDao;
    protected IUserDao userDao;
    protected IUsersManager usersManager;
    protected IDeviceDao deviceDao;
    protected IDevicesManager devicesManager;
    protected IWorkDao workDao;
    protected IWorksManager worksManager;
    protected IMaintenanceDao maintenanceDao;
    protected IMaintenancesManager maintenancesManager;

    @Override
    public void setTypesDao(ICatalogDao typesDao) {
        this.typesDao = typesDao;
    }

    @Override
    public ICatalogDao getTypesDao() {
        return typesDao;
    }

    @Override
    public void setCategoriesDao(ICatalogDao categoriesDao) {
        this.categoriesDao = categoriesDao;
    }

    @Override
    public ICatalogDao getCategoriesDao() {
        return categoriesDao;
    }

    @Override
    public void setManufacturesDao(ICatalogDao manufacturesDao) {
        this.manufacturesDao = manufacturesDao;
    }

    @Override
    public ICatalogDao getManufacturesDao() {
        return manufacturesDao;
    }

    @Override
    public void setPlacesDao(ICatalogDao placesDao) {
        this.placesDao = placesDao;
    }

    @Override
    public ICatalogDao getPlacesDao() {
        return placesDao;
    }

    @Override
    public void setLocationPositionsDao(ICatalogDao locationPositionsDao) {
        this.locationPositionsDao = locationPositionsDao;
    }

    @Override
    public ICatalogDao getLocationPositionsDao() {
        return locationPositionsDao;
    }

    @Override
    public IUserDao getUserDao() {
        return userDao;
    }

    @Override
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public IUsersManager getUsersManager() {
        return usersManager;
    }

    @Override
    public void setUsersManager(IUsersManager usersManager) {
        this.usersManager = usersManager;
    }

    @Override
    public IDeviceDao getDeviceDao() {
        return deviceDao;
    }

    @Override
    public void setDeviceDao(IDeviceDao deviceDao) {
        this.deviceDao = deviceDao;
    }

    @Override
    public IDevicesManager getDevicesManager() {
        return devicesManager;
    }

    @Override
    public void setDevicesManager(IDevicesManager devicesManager) {
        this.devicesManager = devicesManager;
    }

    @Override
    public IWorkDao getWorkDao() {
        return workDao;
    }

    @Override
    public void setWorkDao(IWorkDao workDao) {
        this.workDao = workDao;
    }

    @Override
    public IWorksManager setWorksManager() {
        return worksManager;
    }

    @Override
    public void setWorksManager(IWorksManager worksManager) {
        this.worksManager = worksManager;
    }

    @Override
    public void setMaintenanceDao(IMaintenanceDao maintenanceDao) {
        this.maintenanceDao = maintenanceDao;
    }

    @Override
    public IMaintenanceDao getMaintenanceDao() {
        return maintenanceDao;
    }

    @Override
    public void setMaintenancesManager(IMaintenancesManager maintenancesManager) {
        this.maintenancesManager = maintenancesManager;
    }

    @Override
    public IMaintenancesManager getMaintenancesManager() {
        return maintenancesManager;
    }
}