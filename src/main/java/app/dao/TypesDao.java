package app.dao;

import app.dao.api.ICatalogDao;
import app.dto.user.api.IUser;

import java.io.File;
import java.sql.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TypesDao implements ICatalogDao<IUser, String> {

    private final String DB_PATH;

    private final String DB_ADDRESS;

    private static TypesDao instance;

    private Connection connection;

    private TypesDao() {
        try {
            DB_PATH = String.valueOf(getClass().getClassLoader().getResource("sqlite" + File.separator + "pdis.db"));
            DB_ADDRESS = "jdbc:sqlite:" + DB_PATH;
            connection = DriverManager.getConnection(DB_ADDRESS);
            System.out.println("TypesDao: Connected!");
        } catch (SQLException e) {
           throw new RuntimeException(e); // TODO
        }
    }

    @Override
    public boolean isContainValue(String type) {
        return getAll().contains(type.toLowerCase().trim());
    }

    @Override
    public Set<String> getAll() {
        try(Statement statement = connection.createStatement()) {
            Set<String> types = new HashSet<>();
            String query = "SELECT type FROM types";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                types.add(resultSet.getString("type"));
            }
            return types;
        } catch (SQLException e) {
            System.out.println("Ошибка!"); // TODO
            System.out.println(e.getMessage());
            return Collections.emptySet();
        }
    }

    @Override
    public boolean create(IUser creator, String type) {
        if(creator.checkPermission("CAN_CREATE_TYPE")) {
            String preparedQuery = "INSERT INTO types ('type') VALUES(?)";
            try(PreparedStatement statement = connection.prepareStatement(preparedQuery)){
                statement.setObject(1, type.toLowerCase().trim());
                statement.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.out.println("Ошибка!"); // TODO
                System.out.println(e.getMessage());
                return false;
            }
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
            String preparedQuery = "DELETE FROM types WHERE type = ?";
            try(PreparedStatement statement = connection.prepareStatement(preparedQuery)){
                statement.setObject(1, type.toLowerCase().trim());
                statement.execute();
                return true;
            } catch (SQLException e) {
                System.out.println("Ошибка!"); // TODO
                System.out.println(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static synchronized TypesDao getInstance() {
        if(instance == null) {
            instance = new TypesDao();
        } else {
            throw new IllegalArgumentException("Объект TypesDao уже создан!");
        }
        return instance;
    }
}