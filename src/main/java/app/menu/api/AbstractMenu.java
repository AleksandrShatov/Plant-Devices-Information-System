package app.menu.api;

import app.dao.api.*;
import app.dto.user.api.IUser;
import app.menu.api.IMenu;
import app.services.api.IDevicesManager;
import app.services.api.IMaintenancesManager;
import app.services.api.IUsersManager;
import app.services.api.IWorksManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public abstract class AbstractMenu implements IMenu {

    private Map<Integer, IMenu> childMenus;

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

    public AbstractMenu() {
//        this.childMenus = new TreeMap<>(Collections.reverseOrder());
        this.childMenus = new TreeMap<>();
    }

    public Map<Integer, IMenu> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(Map<Integer, IMenu> childMenus) {
        this.childMenus = childMenus;
    }

    public void addMenu(Integer num, IMenu menu){
        this.childMenus.put(num, menu);
    }

    protected IMenu getMenu(Integer num){
        return this.childMenus.get(num);
    }

    public int show(IUser currentUser) {
        int choice = 0;
        do {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(this.getTitle(currentUser) + ":"); //TODO

            Map<Integer, IMenu> childMenus = this.getChildMenus();

            Set<Map.Entry<Integer, IMenu>> entries = childMenus.entrySet();

            for (Map.Entry<Integer, IMenu> entry : entries) {
                System.out.println(entry.getKey() + ". " + entry.getValue().getTitle(currentUser));
            }

            try {
                String line = reader.readLine();
                choice = Integer.parseInt(line);

                this.getMenu(choice).show(currentUser);
            } catch (NumberFormatException | IOException e) {
                System.out.println("Введено неверное значение! Попробуйте заново.");
            }

        } while (choice < 3); //TODO
        return 0;
    }

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