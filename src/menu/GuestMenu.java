package menu;

import dto.IUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuestMenu extends AbstractMenu {

    private static GuestMenu instance;

    private GuestMenu() {

    }

    public int show(IUser currentUser) { // TODO нужно упростить, т.к. есть всё кроме добавления и удаления
        int choice = 0;
        do {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Гостевое меню:");
            System.out.println("1. Просмотреть список всех пользователей.");
            System.out.println("2. Поиск пользователя по логину.");
            System.out.println("3. Поиск пользователей по имени.");
            System.out.println("4. Поиск пользователей по роли.");
            System.out.println("5. Выход в предыдущее меню.");
            try {
                String line = reader.readLine();
                choice = Integer.parseInt(line);

                switch (choice) {
                    case 1:
                        System.out.println("Запрос на ввод данных");
                        break;

                    case 2:

                        break;

                    case 3:

                        break;

                    case 4:

                        break;

                    case 5:
                        return 0;
                }


            } catch (IOException e) {
                System.out.println("Введено неверное значение! Попробуйте заново.");
            }


        } while (choice < 3);


        return 0;

    }

    public static GuestMenu getInstance() {
        if(instance == null) {
            instance = new GuestMenu();
        } else {
            throw new IllegalArgumentException("Объект GuestMenu уже существует!");
        }
        return instance;
    }

}
