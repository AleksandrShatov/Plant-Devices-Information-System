package menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu extends AbstractMenu {

    private static MainMenu instance;

    private SelectionMenu selectionMenu;

    private GuestMenu guestMenu;

    private MainMenu() {

    }

    public int show() {
        int choice = 0;
        do {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Основное меню:");
            System.out.println("1. Войти в аккаунт.");
            System.out.println("2. Работать как гость.");
            System.out.println("3. Выход из приложения.");
            try {
                String line = reader.readLine();
                choice = Integer.parseInt(line);

                switch (choice) {
                    case 1:
                        System.out.println("Запрос на ввод данных");
                        choice = selectionMenu.show();
                        break;

                    case 2:
                        choice = guestMenu.show();
                        break;

                    case 3:
                        System.out.println("Завершение работы приложения.");
                        break;
                }


            } catch (IOException e) {
                System.out.println("Введено неверное значение! Попробуйте заново.");
            }


        } while (choice < 3);
        return 0;
    }

    public void setSelectionMenu(SelectionMenu selectionMenu) {
        this.selectionMenu = selectionMenu;
    }

    public void setGuestMenu(GuestMenu guestMenu) {
        this.guestMenu = guestMenu;
    }

    public static MainMenu getInstance() {
        if(instance == null) {
            instance = new MainMenu();
        } else {
            throw new IllegalArgumentException("Объект MainMenu уже существует!");
        }
        return instance;
    }
}
