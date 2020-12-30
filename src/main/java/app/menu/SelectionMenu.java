package app.menu;

import app.dto.user.api.IUser;
import app.menu.api.AbstractMenu;
import app.menu.catalogs.CatalogsMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionMenu extends AbstractMenu {

    private static SelectionMenu instance;

    private SelectionMenu() {
        super();
    }

    @Override
    public String getTitle(IUser currentUser) {
        return "Войти в аккаунт";
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
