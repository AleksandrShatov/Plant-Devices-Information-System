package menu;

import dto.IUser;
import menu.catalogs.CatalogsMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionMenu extends AbstractMenu {

    private static SelectionMenu instance;

    private UsersMenu usersMenu;
    private CatalogsMenu catalogsMenu;

    private SelectionMenu() {

    }

    public int show(IUser currentUser) {
        int choice = 0;
        do {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Выберите необходимое меню, для дальнейшей работы:");
            System.out.println("1. Меню для пользователей.");
            System.out.println("2. Меню для устройств.");
            System.out.println("3. Меню для работ.");
            System.out.println("4. Меню для ППР.");
            // TODO проверка на роль для работы со списками
            System.out.println("5. Меню для работы с каталогами.");
            System.out.println("6. Выход в предыдущее меню.");
            try {
                String line = reader.readLine();
                choice = Integer.parseInt(line);

                switch (choice) {
                    case 1:
                        choice = usersMenu.show(currentUser);
                        break;

                    case 2:

                        break;

                    case 3:

                        break;

                    case 4:

                        break;

                    case 5:
                        choice = catalogsMenu.show(currentUser);
                        break;

                    case 6:
                        return 0;
                }


            } catch (IOException e) {
                System.out.println("Введено неверное значение! Попробуйте заново.");
            }


        } while (choice < 7 && choice >= 0);


        return 13;
    }

    public void setUsersMenu(UsersMenu usersMenu) {
        this.usersMenu = usersMenu;
    }

    public void setCatalogsMenu(CatalogsMenu catalogsMenu) {
        this.catalogsMenu = catalogsMenu;
    }

    public static SelectionMenu getInstance() {
        if(instance == null) {
            instance = new SelectionMenu();
        } else {
            throw new IllegalArgumentException("Объект SelectionMenu уже существует!");
        }
        return instance;
    }


}
