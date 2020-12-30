package dao;

import dto.IUser;
import java.io.File;
import java.sql.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ManufacturesDao implements ICatalogDao<IUser, String> {

    private static final String DB_PATH = "MainModule" + File.separator + "resources" + File.separator + "sqlite" + File.separator + "pdis.db";

    private static final String DB_ADDRESS = "jdbc:sqlite:" + DB_PATH;

    private static final String JDBC_CLASS = "org.sqlite.JDBC";

    private static ManufacturesDao instance;

    private Connection connection;

    private ManufacturesDao() {
        try {
            Class.forName(JDBC_CLASS);
            connection = DriverManager.getConnection(DB_ADDRESS);
            System.out.println("ManufacturesDao: Connected!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ManufacturesDao: Ошибка подключения к БД!");
        }
    }

    @Override
    public boolean isContainValue(String manufacturer) {
        return getAll().contains(manufacturer.toUpperCase().trim());
    }

    @Override
    public Set<String> getAll() {
        try(Statement statement = connection.createStatement()) {
            Set<String> manufacturers = new HashSet<>();
            String query = "SELECT manufacturer FROM manufacturers";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                manufacturers.add(resultSet.getString("manufacturer"));
            }
            return manufacturers;
        } catch (SQLException e) {
            System.out.println("Ошибка!"); // TODO
            System.out.println(e.getMessage());
            return Collections.emptySet();
        }
    }

    @Override
    public boolean create(IUser creator, String manufacturer) {
        if(creator.checkPermission("CAN_CREATE_MANUFACTURER")) {
            String preparedQuery = "INSERT INTO manufacturers ('manufacturer') VALUES(?)";
            try(PreparedStatement statement = connection.prepareStatement(preparedQuery)){
                statement.setObject(1, manufacturer.toUpperCase().trim());
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
    public boolean update(IUser updater, String manufacturer) { // TODO
        if(updater.checkPermission("CAN_UPDATE_MANUFACTURER")) {

            return true;
        }
        return false;
    }

    @Override
    public boolean delete(IUser deleter, String manufacturer) {
        if(deleter.checkPermission("CAN_DELETE_MANUFACTURER")) {
            String preparedQuery = "DELETE FROM manufacturers WHERE manufacturer = ?";
            try(PreparedStatement statement = connection.prepareStatement(preparedQuery)){
                statement.setObject(1, manufacturer.toUpperCase().trim());
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

    public static ManufacturesDao getInstance() {
        if(instance == null) {
            instance = new ManufacturesDao();
        } else {
            throw new IllegalArgumentException("Объект ManufacturesDao уже создан!");
        }
        return instance;
    }
}