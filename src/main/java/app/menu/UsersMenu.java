package app.menu;

import app.dto.user.api.IUser;
import app.menu.api.AbstractMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UsersMenu extends AbstractMenu {

    private static UsersMenu instance;

    private UsersMenu() {
        super();
    }

    @Override
    public String getTitle(IUser currentUser) {
        return "Меню для пользователей";
    }

    public int show(IUser currentUser) {
        int choice = 0;
        do {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Меню работы с пользователями:");
            System.out.println("1. Посмотреть список всех пользователей.");
            System.out.println("2. Поиск пользователя по логину.");
            System.out.println("3. Поиск пользователей по имени.");
            System.out.println("4. Редактирование пользователя.");
            System.out.println("5. Добавление нового пользователя.");
            System.out.println("6. Удаление пользователя.");
            System.out.println("7. Выход в предыдущее меню.");
            try {
                String line = reader.readLine();
                choice = Integer.parseInt(line);

                switch (choice) {
                    case 1:
                        System.out.println("СПИСОК ВСЕХ ПОЛЬЗОВАТЕЛЕЙ:");
                        for (IUser user: userDao.getAll()) {
                            System.out.println(user);
                        }
                        break;

                    case 2:

                        break;

                    case 3:

                        break;

                    case 4:

                        break;

                    case 5:

                        break;

                    case 6:

                        break;

                    case 7:
                        return 0;
                }


            } catch (IOException e) {
                System.out.println("Введено неверное значение! Попробуйте заново.");
            }


        } while (choice < 8 && choice >= 0);


        return 13;
    }

    public static UsersMenu getInstance() {
        if(instance == null) {
            instance = new UsersMenu();
        } else {
            throw new IllegalArgumentException("Объект UsersMenu уже существует!");
        }
        return instance;
    }
}
