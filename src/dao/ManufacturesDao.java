package dao;

import dataForTesting.DataManufacturersTest;
import dto.IUser;

import java.util.HashSet;
import java.util.Set;

public class ManufacturesDao implements ICatalogDao<IUser, String> {

    private static ManufacturesDao instance;

    private Set<String> manufacturers;

    private ManufacturesDao() {
        readManufacturers();
    }

    private boolean readManufacturers() { //TODO чтение из БД
        if(this.manufacturers == null) {
            Set<String> manufacturersFromDb = DataManufacturersTest.getInstance().getManufacturers();
            this.manufacturers = new HashSet<>();
            for (String manufacturer : manufacturersFromDb) {
                this.manufacturers.add(manufacturer.toUpperCase().trim());
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isContainValue(String manufacturer) {
        return manufacturers.contains(manufacturer.toUpperCase().trim());
    }

    @Override
    public Set<String> getAll() {
        return manufacturers;
    }

    @Override
    public boolean create(IUser creator, String manufacturer) {
        if(creator.checkPermission("CAN_CREATE_MANUFACTURER")) {
            manufacturers.add(manufacturer.toUpperCase().trim());
            return true;
        }
        return false;
    }

    @Override
    public boolean update(IUser updater, String manufacturer) {
        if(updater.checkPermission("CAN_UPDATE_MANUFACTURER")) {

            return true;
        }
        return false;
    }

    @Override
    public boolean delete(IUser deleter, String manufacturer) {
        if(deleter.checkPermission("CAN_DELETE_MANUFACTURER")) {
            return manufacturers.remove(manufacturer.toUpperCase().trim());
        }
        return false;
    }

    public static ManufacturesDao getInstance() {
        if(instance == null) {
            instance = new ManufacturesDao();
        } else {
            throw new IllegalArgumentException("Объект ManufacturesDao уже создан!");
        }
        return instance;
    }
}
