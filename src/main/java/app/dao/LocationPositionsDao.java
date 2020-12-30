package app.dao;

import app.dao.api.ICatalogDao;
import app.dto.user.api.IUser;

import java.util.HashSet;
import java.util.Set;

public class LocationPositionsDao implements ICatalogDao<IUser, String> {

    private static LocationPositionsDao instance;

    private Set<String> locationPositions;

    private LocationPositionsDao() {
        readLocationPositions();
    }

    private boolean readLocationPositions() { //TODO чтение из БД
        if(this.locationPositions == null) {
            this.locationPositions = new HashSet<>();
            locationPositions.add("1500LS15");
            locationPositions.add("2200TS11");
            locationPositions.add("1150RP28");
            locationPositions.add("5500BR19");
            locationPositions.add("4400LI33");
            locationPositions.add("2700TS55");
            locationPositions.add("2500MT13");
            locationPositions.add("2250LS13");
            locationPositions.add("2700PT31");
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
