package dao;

import dataForTesting.DataUsersTest;
import dto.IUser;

import java.util.*;

public class UserDao implements IUserDao {

    private static UserDao instance;

    private Map<Integer, IUser> users;

    public UserDao() {
        readUsers();
    }

    private boolean readUsers() { //TODO чтение из БД
        if(this.users == null) {
            List<IUser> usersFromDb = DataUsersTest.getInstance().getUsers();
            this.users = new HashMap<>();
            for (IUser user : usersFromDb) {
                this.users.put(user.getId(), user);
            }
            return true;
        }
        return false;
    }

    @Override
    public IUser getById(Integer userId) {
        for (IUser user : getAll()) {
            if(userId.intValue() == user.getId()) {
                return user;
            }
        }
        return null; // TODO
    }

    @Override
    public List<IUser> getAll() {
        Set<Map.Entry<Integer, IUser>> setOfUsers = this.users.entrySet();
        List<IUser> allUsers = new ArrayList<>();
        for (Map.Entry<Integer, IUser> mapElement : setOfUsers) {
            IUser user = mapElement.getValue();
            allUsers.add(user);
        }
        return allUsers;
    }

    @Override
    public boolean create(IUser whoCreate, IUser newUser) {
        if(whoCreate.checkPermission("CAN_CREATE_USER")) {
            users.put(users.size(), newUser);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(IUser whoUpdate, IUser userForUpdate) { //TODO
        if(whoUpdate.checkPermission("CAN_UPDATE_USER")) {

            return true;
        }
        return false;
    }

    @Override
    public boolean delete(IUser whoDelete, Integer userId) {
        if(whoDelete.checkPermission("CAN_DELETE_USER")) {
            IUser user = getById(userId);
            if(user != null) {
                return users.remove(user.getId(), user);
            }
        }
        return false;
    }

    public static UserDao getInstance() {
        if(instance == null) {
            instance = new UserDao();
        } else {
            throw new IllegalArgumentException("Объект UserDao уже создан!");
        }
        return instance;
    }
}
