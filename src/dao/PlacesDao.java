package dao;

import dto.IUser;

import java.util.HashSet;
import java.util.Set;

public class PlacesDao implements ICatalogDao<IUser, String> {

    private static PlacesDao instance;

    private Set<String> places;

    private PlacesDao() {
        readPlaces();
    }

    private boolean readPlaces() { //TODO чтение из БД
        if(this.places == null) {
            this.places = new HashSet<>();
            places.add("ЦЕХ ДСП");
            places.add("ЦЕХ ЛДСП");
            places.add("РУБИТЕЛЬНОЕ ОТДЕЛЕНИЕ");
            places.add("ОТДЕЛЕНИЕ СУШКИ");
            places.add("ТЕРМОМАСЛЯНАЯ КОТЕЛЬНАЯ");
            return true;
        }
        return false;
    }

    @Override
    public boolean isContainValue(String place) {
        return places.contains(place.toUpperCase().trim());
    }

    @Override
    public Set<String> getAll() {
        return places;
    }

    @Override
    public boolean create(IUser creator, String place) {
        if(creator.checkPermission("CAN_CREATE_PLACE")) {
            places.add(place.toUpperCase().trim());
            return true;
        }
        return false;
    }

    @Override
    public boolean update(IUser updater, String place) {
        if(updater.checkPermission("CAN_UPDATE_PLACE")) {

            return true;
        }
        return false;
    }

    @Override
    public boolean delete(IUser deleter, String place) {
        if(deleter.checkPermission("CAN_DELETE_PLACE")) {
            return places.remove(place.toUpperCase().trim());
        }
        return false;
    }

    public static PlacesDao getInstance() {
        if(instance == null) {
            instance = new PlacesDao();
        } else {
            throw new IllegalArgumentException("Объект PlacesDao уже создан!");
        }
        return instance;
    }
}
