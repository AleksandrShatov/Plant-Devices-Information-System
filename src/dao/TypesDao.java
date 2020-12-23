package dao;

import dataForTesting.DataTypesTest;
import dto.IUser;

import java.util.HashSet;
import java.util.Set;

public class TypesDao implements ICatalogDao<IUser, String>{

    private static TypesDao instance;

    private Set<String> types;

    private TypesDao() {
        readTypes();
    }

    private boolean readTypes() { //TODO чтение из БД
        if(this.types == null) {
            Set<String> typesFromDb = DataTypesTest.getInstance().getTypes();
            this.types = new HashSet<>();
            for (String type : typesFromDb) {
                this.types.add(type.toLowerCase().trim());
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isContainValue(String type) {
        return types.contains(type.toLowerCase().trim());
    }

    @Override
    public Set<String> getAll() {
        return types;
    }

    @Override
    public boolean create(IUser creator, String type) {
        if(creator.checkPermission("CAN_CREATE_TYPE")) {
            types.add(type.toLowerCase().trim());
            return true;
        }
        return false;
    }

    @Override
    public boolean update(IUser updater, String type) { // TODO
        if(updater.checkPermission("CAN_UPDATE_TYPE")) {

            return true;
        }
        return false;
    }

    @Override
    public boolean delete(IUser deleter, String type) {
        if(deleter.checkPermission("CAN_DELETE_TYPE")) {
            return types.remove(type.toLowerCase().trim());
        }
        return false;
    }

    public static TypesDao getInstance() {
        if(instance == null) {
            instance = new TypesDao();
        } else {
            throw new IllegalArgumentException("Объект TypesDao уже создан!");
        }
        return instance;
    }
}