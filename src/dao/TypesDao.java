package dao;

import dto.IUser;
import java.io.File;
import java.sql.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TypesDao implements ICatalogDao<IUser, String>{

    private static final String DB_PATH = "MainModule" +  File.separator + "resources" + File.separator + "sqlite" + File.separator + "pdis.db";

    private static final String DB_ADDRESS = "jdbc:sqlite:" + DB_PATH;

    private static final String JDBC_CLASS = "org.sqlite.JDBC";

    private static TypesDao instance;

    private Connection connection;

    private Set<String> types;

    private TypesDao() {
        try {
            Class.forName(JDBC_CLASS);
            connection = DriverManager.getConnection(DB_ADDRESS);
            System.out.println("Connected!");
        } catch (Exception e) {
            System.out.println("Ошибка подключения к БД!");
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
            String prepareQuery = "INSERT INTO types ('type') VALUES(?)";
            try(PreparedStatement statement = connection.prepareStatement(prepareQuery)){
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
            String prepareQuery = "DELETE FROM types WHERE type = ?";
            try(PreparedStatement statement = connection.prepareStatement(prepareQuery)){
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