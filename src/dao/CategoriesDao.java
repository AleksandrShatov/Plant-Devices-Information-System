package dao;

import dto.IUser;

import java.util.HashSet;
import java.util.Set;

public class CategoriesDao implements ICatalogDao<IUser, String> {

    private static CategoriesDao instance;

    private Set<String> categories;

    private CategoriesDao() {
        readCategories();
    }

    private boolean readCategories() { //TODO чтение из БД
        if(this.categories == null) {
            this.categories = new HashSet<>();
            categories.add("КИП");
            categories.add("МЕХАНИКА");
            categories.add("ЭЛЕКТРОНИКА");
            categories.add("ГИДРАВЛИКА");
            categories.add("ЭНЕРГЕТИКА");
            categories.add("ЛАБОРАТОРНОЕ ОБОРУДОВАНИЕ");
            categories.add("ПНЕВМАТИКА");
            return true;
        }
        return false;
    }

    @Override
    public boolean isContainValue(String category) {
        return categories.contains(category.toUpperCase().trim());
    }

    @Override
    public Set<String> getAll() {
        return categories;
    }

    @Override
    public boolean create(IUser creator, String category) {
        if(creator.checkPermission("CAN_CREATE_CATEGORY")) {
            categories.add(category.toUpperCase().trim());
            return true;
        }
        return false;
    }

    @Override
    public boolean update(IUser updater, String category) {
        if(updater.checkPermission("CAN_UPDATE_CATEGORY")) {

            return true;
        }
        return false;
    }

    @Override
    public boolean delete(IUser deleter, String category) {
        if(deleter.checkPermission("CAN_DELETE_CATEGORY")) {
            return categories.remove(category.toUpperCase().trim());
        }
        return false;
    }

    public static CategoriesDao getInstance() {
        if(instance == null) {
            instance = new CategoriesDao();
        } else {
            throw new IllegalArgumentException("Объект CategoriesDao уже создан!");
        }
        return instance;
    }
}
