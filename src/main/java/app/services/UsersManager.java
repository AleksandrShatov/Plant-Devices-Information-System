package app.services;

import app.dao.UserDao;
import app.dto.user.Permissions;
import app.dto.user.api.IUser;
import app.dto.user.api.UserRole;
import app.services.api.IUsersManager;

import java.util.ArrayList;
import java.util.List;

public class UsersManager implements IUsersManager {

    private static UsersManager instance;

    private UserDao userDao;

    public UsersManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<IUser> getByLogin(String login) {
        List<IUser> usersResult = new ArrayList<>();
        for (IUser user : userDao.getAll()) {
            if(login.equals(user.getLogin())) {
                usersResult.add(user);
            }
        }
        return usersResult;
    }

    @Override
    public List<IUser> getByName(String name) {
        List<IUser> usersResult = new ArrayList<>();
        for (IUser user : userDao.getAll()) {
            if(user.getName().contains(name)) {
                usersResult.add(user);
            }
        }
        return usersResult;
    }

    @Override
    public List<IUser> getByRole(UserRole role) {
        List<IUser> usersResult = new ArrayList<>();
        for (IUser user : userDao.getAll()) {
            if(role.equals(user.getRole())) {
                usersResult.add(user);
            }
        }
        return usersResult;
    }

    @Override
    public List<IUser> getByPermissions(Permissions permissions) { //TODO пока выводим всех пользователей
        return userDao.getAll();
    }

    public static UsersManager getInstance(UserDao userDao) {
        if(instance == null) {
            instance = new UsersManager(userDao);
        } else {
            throw new IllegalArgumentException("Объект UsersManager уже создан!");
        }
        return instance;
    }
}
