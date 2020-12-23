package dataForTesting;

import dto.IUser;
import dto.Permissions;
import dto.User;
import dto.UserRole;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, содержащий стартовый набор пользователей для тестирования
 */
public class DataUsersTest {

    private static DataUsersTest instance;

    private List<IUser> users;

    private DataUsersTest() {
        this.users = new ArrayList<>();
        users.add(new User(123, "Alex", "11111", "Алексин Николай Владимирович", UserRole.Admin, new Permissions()));
        users.add(new User(371, "Alex", "22222", "Горохов Сергей Валентинович", UserRole.Guest, new Permissions()));
        users.add(new User(456, "Bob", "77777", "Прохоров Вадим Петрович", UserRole.Manager, new Permissions()));
        users.add(new User(789, "Dima", "99999", "Стрельченко Дмитрий Сергеевич", UserRole.Moderator, new Permissions()));
        users.add(new User(357, "Alla", "56565", "Никонова Алла Игоревна", UserRole.Admin, new Permissions()));
        users.add(new User(846, "Nikon", "87879", "Перевалов Николай Юрьевич", UserRole.Guest, new Permissions()));
        users.add(new User(914, "Kate", "33333", "Кревчук Екатерина Георгиевна", UserRole.Moderator, new Permissions()));
    }

    public List<IUser> getUsers() {
        return users;
    }

    public static DataUsersTest getInstance() {
        if(instance == null) {
            instance = new DataUsersTest();
        } else {
            throw new IllegalArgumentException("Объект DataUsersTest уже создан!");
        }
        return instance;
    }
}
