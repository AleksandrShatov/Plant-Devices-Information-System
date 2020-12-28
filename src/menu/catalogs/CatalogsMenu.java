package menu.catalogs;

import dto.IUser;
import menu.AbstractMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CatalogsMenu extends AbstractMenu {

    private static CatalogsMenu instance;

    private TypesMenu typesMenu;

    private CatalogsMenu() {

    }

    public int show(IUser currentUser) {
        int choice = 0;
        do {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Меню работы с каталогами:");
            System.out.println("1. Меню работы с типами.");
            System.out.println("2. Меню работы с категориями.");
            System.out.println("3. Меню работы с производителями.");
            System.out.println("4. Меню работы с участками.");
            System.out.println("5. Меню работы с позициями.");
            System.out.println("6. Выход в предыдущее меню.");
            try {
                String line = reader.readLine();
                choice = Integer.parseInt(line);

                switch (choice) {
                    case 1:
                        choice = typesMenu.show(currentUser);
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
                        return 0;
                }


            } catch (IOException e) {
                System.out.println("Введено неверное значение! Попробуйте заново.");
            }


        } while (choice < 7 && choice >= 0);


        return 13;
    }

    public void setTypesMenu(TypesMenu typesMenu) {
        this.typesMenu = typesMenu;
    }

    public static CatalogsMenu getInstance() {
        if(instance == null) {
            instance = new CatalogsMenu();
        } else {
            throw new IllegalArgumentException("Объект CatalogsMenu уже существует!");
        }
        return instance;
    }
}
