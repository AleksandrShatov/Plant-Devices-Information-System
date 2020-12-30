package dao;

import dto.IUser;
import java.io.File;
import java.sql.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CategoriesDao implements ICatalogDao<IUser, String> {

    private static final String DB_PATH = "MainModule" + File.separator + "resources" + File.separator + "sqlite" + File.separator + "pdis.db";

    private static final String DB_ADDRESS = "jdbc:sqlite:" + DB_PATH;

    private static final String JDBC_CLASS = "org.sqlite.JDBC";

    private static CategoriesDao instance;

    private Connection connection;

    private CategoriesDao() {
        try {
            Class.forName(JDBC_CLASS);
            connection = DriverManager.getConnection(DB_ADDRESS);
            System.out.println("CategoriesDao: Connected!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("CategoriesDao: Ошибка подключения к БД!");
        }
    }

    @Override
    public boolean isContainValue(String category) {
        return getAll().contains(category.toUpperCase().trim());
    }

    @Override
    public Set<String> getAll() {
        try(Statement statement = connection.createStatement()) {
            Set<String> categories = new HashSet<>();
            String query = "SELECT category FROM categories";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                categories.add(resultSet.getString("category"));
            }
            return categories;
        } catch (SQLException e) {
            System.out.println("Ошибка!"); // TODO
            System.out.println(e.getMessage());
            return Collections.emptySet();
        }
    }

    @Override
    public boolean create(IUser creator, String category) {
        if(creator.checkPermission("CAN_CREATE_CATEGORY")) {
            String preparedQuery = "INSERT INTO categories ('category') VALUES(?)";
            try(PreparedStatement statement = connection.prepareStatement(preparedQuery)) {
                statement.setObject(1, category.toUpperCase().trim());
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
    public boolean update(IUser updater, String category) {
        if(updater.checkPermission("CAN_UPDATE_CATEGORY")) {

            return true;
        }
        return false;
    }

    @Override
    public boolean delete(IUser deleter, String category) {
        if(deleter.checkPermission("CAN_DELETE_CATEGORY")) {
            String preparedQuery = "DELETE FROM categories WHERE category = ?";
            try(PreparedStatement statement = connection.prepareStatement(preparedQuery)) {
                statement.setObject(1, category.toUpperCase().trim());
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

    public static CategoriesDao getInstance() {
        if(instance == null) {
            instance = new CategoriesDao();
        } else {
            throw new IllegalArgumentException("Объект CategoriesDao уже создан!");
        }
        return instance;
    }
}