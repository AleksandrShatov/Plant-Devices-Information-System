package app.menu;

import app.dto.user.api.IUser;
import app.menu.api.AbstractMenu;

public class MainMenu extends AbstractMenu {

    private static MainMenu instance;

    private MainMenu() {
        super();
    }

    @Override
    public String getTitle(IUser currentUser) {
        return "Основное меню";
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
