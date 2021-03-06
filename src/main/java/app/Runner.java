package app;

import app.dao.*;
import app.dto.user.api.IUser;
import app.menu.*;
import app.menu.api.IMenu;
import app.menu.catalogs.CatalogsMenu;
import app.menu.catalogs.CategoriesMenu;
import app.menu.catalogs.ManufacturersMenu;
import app.menu.catalogs.TypesMenu;
import app.services.DevicesManager;
import app.services.UsersManager;
import app.services.WorksManager;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        /* Создаём все необходимые наборы списков */
        TypesDao typesDao = TypesDao.getInstance();
        CategoriesDao categoriesDao = CategoriesDao.getInstance();
        ManufacturesDao manufacturesDao = ManufacturesDao.getInstance();
        PlacesDao placesDao = PlacesDao.getInstance();
        LocationPositionsDao locationPositionsDao = LocationPositionsDao.getInstance();

        /* Создаём все необходимые сервисы */
        UserDao userDao = UserDao.getInstance();
        UsersManager usersManager = UsersManager.getInstance(userDao);

        DeviceDao deviceDao = DeviceDao.getInstance();
        DevicesManager devicesManager = DevicesManager.getInstance(deviceDao);

        WorkDao workDao = WorkDao.getInstance();
        WorksManager worksManager = WorksManager.getInstance(workDao);

        /* Вызываем методы с проверками */
//        TestAll testAll = TestAll.getInstance();
//        testAll.typesCheck(typesDao, userDao);
//        testAll.categoriesCheck(categoriesDao, userDao);
//        testAll.manufacturersCheck(manufacturesDao, userDao);
//        testAll.placesCheck(placesDao, userDao);
//        testAll.locationPositionsCheck(locationPositionsDao, userDao);
//
//        testAll.usersCheck(userDao, usersManager);
//        testAll.devicesCheck(deviceDao, devicesManager, userDao);
//        testAll.worksCheck(workDao, worksManager, deviceDao, userDao);

        /* Основной цикл работы приложения */
        IUser user = userDao.getById(123); // TODO пока всегда Admin

        System.out.println("Добро пожаловать!");

        UsersMenu usersMenu = UsersMenu.getInstance();
        GuestMenu guestMenu = GuestMenu.getInstance();

        TypesMenu typesMenu = TypesMenu.getInstance();
        CategoriesMenu categoriesMenu = CategoriesMenu.getInstance();
        ManufacturersMenu manufacturersMenu = ManufacturersMenu.getInstance();
        CatalogsMenu catalogsMenu = CatalogsMenu.getInstance();

        SelectionMenu selectionMenu = SelectionMenu.getInstance();

        MainMenu mainMenu = MainMenu.getInstance();

        catalogsMenu.addMenu(1, typesMenu);
        catalogsMenu.addMenu(2, categoriesMenu);
        catalogsMenu.addMenu(3, manufacturersMenu);
        selectionMenu.addMenu(1, usersMenu);
        selectionMenu.addMenu(2, catalogsMenu);
        mainMenu.addMenu(1, selectionMenu);
        mainMenu.addMenu(2, guestMenu);

        // Создаём список menus и заполняем данными
        List<IMenu> menus = new ArrayList<>();

        menus.add(typesMenu);
        menus.add(categoriesMenu);
        menus.add(manufacturersMenu);
        menus.add(catalogsMenu);
        menus.add(usersMenu);
        menus.add(guestMenu);
        menus.add(selectionMenu);
        menus.add(mainMenu);

        for (IMenu menu : menus) {
            menu.setTypesDao(typesDao);
            menu.setCategoriesDao(categoriesDao);
            menu.setManufacturesDao(manufacturesDao);
            menu.setPlacesDao(placesDao);
            menu.setLocationPositionsDao(locationPositionsDao);
            menu.setUserDao(userDao);
            menu.setUsersManager(usersManager);
            menu.setDeviceDao(deviceDao);
            menu.setDevicesManager(devicesManager);
            menu.setWorkDao(workDao);
            menu.setWorksManager(worksManager);
        }

        // Точка запуска приложения
        mainMenu.show(user);

        System.out.println("Приложение завершило работу. До новых встреч.");


    }

    // НЕ РАБОТАЕТ!
    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}