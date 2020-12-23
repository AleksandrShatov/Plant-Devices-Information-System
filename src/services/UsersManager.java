package services;

import dao.UserDao;
import dto.*;

import java.util.*;

public class UsersManager implements IUsersManager{

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
