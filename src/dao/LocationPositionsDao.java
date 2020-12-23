package dao;

import dataForTesting.DataLocationPositionsTest;
import dto.IUser;

import java.util.HashSet;
import java.util.Set;

public class LocationPositionsDao implements ICatalogDao<IUser, String>{

    private static LocationPositionsDao instance;

    private Set<String> locationPositions;

    private LocationPositionsDao() {
        readLocationPositions();
    }

    private boolean readLocationPositions() { //TODO чтение из БД
        if(this.locationPositions == null) {
            Set<String> locationPositionsFromDb = DataLocationPositionsTest.getInstance().getLocationPositions();
            this.locationPositions = new HashSet<>();
            for (String locationPosition : locationPositionsFromDb) {
                this.locationPositions.add(locationPosition.toUpperCase().trim());
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean isContainValue(String locationPosition) {
        return locationPositions.contains(locationPosition.toUpperCase().trim());
    }

    @Override
    public Set<String> getAll() {
        return locationPositions;
    }

    @Override
    public boolean create(IUser creator, String locationPosition) {
        if(creator.checkPermission("CAN_CREATE_LOCATION_POSITION")) {
            locationPositions.add(locationPosition.toUpperCase().trim());
            return  true;
        }
        return false;
    }

    @Override
    public boolean update(IUser updater, String locationPosition) {
        if(updater.checkPermission("CAN_UPDATE_LOCATION_POSITION")) {

            return true;
        }
        return false;
    }

    @Override
    public boolean delete(IUser deleter, String locationPosition) {
        if(deleter.checkPermission("CAN_DELETE_LOCATION_POSITION")) {
            return locationPositions.remove(locationPosition.toUpperCase().trim());
        }
        return false;
    }

    public static LocationPositionsDao getInstance() {
        if(instance == null) {
            instance = new LocationPositionsDao();
        } else {
            throw new IllegalArgumentException("Объект LocationPositionsDao уже создан!");
        }
        return instance;
    }

}
