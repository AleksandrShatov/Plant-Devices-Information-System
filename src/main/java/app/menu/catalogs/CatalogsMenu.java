package app.menu.catalogs;

import app.dto.user.api.IUser;
import app.menu.api.AbstractMenu;

public class CatalogsMenu extends AbstractMenu {

    private static CatalogsMenu instance;

    private CatalogsMenu() {
        super();
    }

    @Override
    public String getTitle(IUser currentUser) {
        return "Меню для работы с каталогами";
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
