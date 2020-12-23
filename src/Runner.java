import dao.*;
import dto.*;
import services.DevicesManager;
import services.UsersManager;
import services.WorksManager;

import java.time.LocalTime;
import java.util.List;

public class Runner {


    public static void main(String[] args) {

        /* Создаём все необходимые наборы списков */
        TypesDao typesDao = TypesDao.getInstance();
        CategoriesDao categoriesDao = CategoriesDao.getInstance();
        ManufacturesDao manufacturesDao = ManufacturesDao.getInstance();
        PlacesDao placesDao = PlacesDao.getInstance();
        LocationPositionsDao locationPositionsDao = LocationPositionsDao.getInstance();

        /* Создаём все необходимые менеджеры */
        UserDao userDao = UserDao.getInstance();
        UsersManager usersManager = UsersManager.getInstance(userDao);

        DeviceDao deviceDao = DeviceDao.getInstance();
        DevicesManager devicesManager = DevicesManager.getInstance(deviceDao);

        WorkDao workDao = WorkDao.getInstance();
        WorksManager worksManager = WorksManager.getInstance(workDao);

        /* Вызываем методы с проверками */
        typesCheck(typesDao, userDao);
        categoriesCheck(categoriesDao, userDao);
        manufacturersCheck(manufacturesDao, userDao);
        placesCheck(placesDao, userDao);
        locationPositionsCheck(locationPositionsDao, userDao);

        usersCheck(userDao, usersManager);
        devicesCheck(deviceDao, devicesManager, userDao);
        worksCheck(workDao, worksManager, deviceDao, userDao);
    }

    public static void typesCheck(TypesDao typesDao, UserDao userDao) {
        /* Проверяем работу TypesDao */
        // Вывод всех типов
        System.out.println("Вывод всех типов:");
        for (String type: typesDao.getAll()) {
            System.out.println(type);
        }
        // Проверка наличия типов в каталоге
        String type1 = "мясорубка";
        String type2 = "частотный преобразователь";
        System.out.println("Проверка наличия типов в каталоге:");
        System.out.println("Тип '" + type1 + "' " + (typesDao.isContainValue(type1) ? "" : "не") + " содержится в каталоге.");
        System.out.println("Тип '" + type2 + "' " + (typesDao.isContainValue(type2) ? "" : "не") + " содержится в каталоге.");
        // Удаление типа
        IUser deleter = userDao.getById(123);
        System.out.println("Удаляем тип '" + type2 + "' из каталога!");
        typesDao.delete(deleter, type2);
        // Вывод всех типов после удаления типа
        System.out.println("Вывод всех типов после удаления типа:");
        for (String type: typesDao.getAll()) {
            System.out.println(type);
        }
        // Добавление нового типа
        IUser creator = deleter;
        System.out.println("Добавляем тип '" + type1 + "' в каталог!");
        typesDao.create(creator, type1);
        // Вывод всех типов после добавления нового типа
        System.out.println("Вывод всех типов после добавления нового типа:");
        for (String type: typesDao.getAll()) {
            System.out.println(type);
        }

    }

    public static void categoriesCheck(CategoriesDao categoriesDao, UserDao userDao) {
        /* Проверяем работу CategoriesDao */
        // Вывод всех категорий
        System.out.println("Вывод всех категорий:");
        for (String category: categoriesDao.getAll()) {
            System.out.println(category);
        }
        // Проверка наличия категорий в каталоге
        String category1 = "пневматика";
        String category2 = "Технология";
        System.out.println("Проверка наличия категорий в каталоге:");
        System.out.println("Категория '" + category1 + "' " + (categoriesDao.isContainValue(category1) ? "" : "не") + " содержится в каталоге.");
        System.out.println("Категория '" + category2 + "' " + (categoriesDao.isContainValue(category2) ? "" : "не") + " содержится в каталоге.");
        // Удаление категории
        IUser deleter = userDao.getById(123);
        System.out.println("Удаляем категорию '" + category1 + "' из каталога!");
        categoriesDao.delete(deleter, category1);
        // Вывод всех категорий после удаления категории
        System.out.println("Вывод всех категорий после удаления категории:");
        for (String category: categoriesDao.getAll()) {
            System.out.println(category);
        }
        // Добавление новой категории
        IUser creator = deleter;
        System.out.println("Добавляем категорию '" + category2 + "' в каталог!");
        categoriesDao.create(creator, category2);
        // Вывод всех категорий после добавления новой категории
        System.out.println("Вывод всех категорий после добавления новой категории:");
        for (String category: categoriesDao.getAll()) {
            System.out.println(category);
        }

    }

    public static void manufacturersCheck(ManufacturesDao manufacturesDao, UserDao userDao) {
        /* Проверяем работу ManufacturesDao */
        // Вывод всех производителей
        System.out.println("Вывод всех производителей:");
        for (String type: manufacturesDao.getAll()) {
            System.out.println(type);
        }
        // Проверка наличия производителей в каталоге
        String manufacturer1 = "Omron";
        String manufacturer2 = "Delta";
        System.out.println("Проверка наличия производителей в каталоге:");
        System.out.println("Производитель '" + manufacturer1 + "' " + (manufacturesDao.isContainValue(manufacturer1) ? "" : "не") + " содержится в каталоге.");
        System.out.println("Производитель '" + manufacturer2 + "' " + (manufacturesDao.isContainValue(manufacturer2) ? "" : "не") + " содержится в каталоге.");
        // Удаление производителя
        IUser deleter = userDao.getById(123);
        System.out.println("Удаляем производителя '" + manufacturer1 + "' из каталога!");
        manufacturesDao.delete(deleter, manufacturer1);
        // Вывод всех производителей после удаления производителя
        System.out.println("Вывод всех производителей после удаления производителя:");
        for (String manufacturer: manufacturesDao.getAll()) {
            System.out.println(manufacturer);
        }
        // Добавление нового производителя
        IUser creator = deleter;
        System.out.println("Добавляем производителя '" + manufacturer2 + "' в каталог!");
        manufacturesDao.create(creator, manufacturer2);
        // Вывод всех производителей после добавления нового производителя
        System.out.println("Вывод всех производителей после добавления нового производителя:");
        for (String manufacturer: manufacturesDao.getAll()) {
            System.out.println(manufacturer);
        }

    }

    public static void placesCheck(PlacesDao placesDao, UserDao userDao) {
        /* Проверяем работу PlacesDao */
        // Вывод всех участков
        System.out.println("Вывод всех участков:");
        for (String place: placesDao.getAll()) {
            System.out.println(place);
        }
        // Проверка наличия участка в каталоге
        String place1 = "Цех ЛДСП";
        String place2 = "Цех Импрегнирования";
        System.out.println("Проверка наличия участков в каталоге:");
        System.out.println("Участок '" + place1 + "' " + (placesDao.isContainValue(place1) ? "" : "не") + " содержится в каталоге.");
        System.out.println("Участок '" + place2 + "' " + (placesDao.isContainValue(place2) ? "" : "не") + " содержится в каталоге.");
        // Удаление участка
        IUser deleter = userDao.getById(123);
        System.out.println("Удаляем участок '" + place1 + "' из каталога!");
        placesDao.delete(deleter, place1);
        // Вывод всех участков после удаления участка
        System.out.println("Вывод всех участков после удаления участка:");
        for (String place: placesDao.getAll()) {
            System.out.println(place);
        }
        // Добавление нового участка
        IUser creator = deleter;
        System.out.println("Добавляем участок '" + place2 + "' в каталог!");
        placesDao.create(creator, place2);
        // Вывод всех участков после добавления нового участка
        System.out.println("Вывод всех участков после добавления нового участка:");
        for (String place: placesDao.getAll()) {
            System.out.println(place);
        }

    }

    public static void locationPositionsCheck(LocationPositionsDao locationPositionsDao, UserDao userDao) { // TODO
        /* Проверяем работу LocationPositionsDao */
        // Вывод всех позиций
        System.out.println("Вывод всех позиций:");
        for (String locationPosition: locationPositionsDao.getAll()) {
            System.out.println(locationPosition);
        }
        // Проверка наличия позиции в каталоге
        String locationPosition1 = "2500mt13";
        String locationPosition2 = "3200tt12";
        System.out.println("Проверка наличия позиций в каталоге:");
        System.out.println("Позиция '" + locationPosition1 + "' " + (locationPositionsDao.isContainValue(locationPosition1) ? "" : "не") + " содержится в каталоге.");
        System.out.println("Позиция '" + locationPosition2 + "' " + (locationPositionsDao.isContainValue(locationPosition2) ? "" : "не") + " содержится в каталоге.");
        // Удаление позиции
        IUser deleter = userDao.getById(123);
        System.out.println("Удаляем позицию '" + locationPosition1 + "' из каталога!");
        locationPositionsDao.delete(deleter, locationPosition1);
        // Вывод всех позиций после удаления позиции
        System.out.println("Вывод всех позиций после удаления позиции:");
        for (String locationPosition : locationPositionsDao.getAll()) {
            System.out.println(locationPosition);
        }
        // Добавление новой позиции
        IUser creator = deleter;
        System.out.println("Добавляем позицию '" + locationPosition2 + "' в каталог!");
        locationPositionsDao.create(creator, locationPosition2);
        // Вывод всех позиций после добавления новой позиции
        System.out.println("Вывод всех позиций после добавления новой позиции:");
        for (String locationPosition: locationPositionsDao.getAll()) {
            System.out.println(locationPosition);
        }

    }

    public static void usersCheck(UserDao userDao, UsersManager usersManager) {
        /* Проверяем работу UserDao и UsersManager */
        // Вывод всех пользователей
        System.out.println("Вывод всех пользователей:");
        for (IUser user: userDao.getAll()) {
            System.out.println(user);
        }
        // Вывод пользователя с заданным id
        Integer id = 123;
        System.out.println("Вывод пользователя с id = " + id + ":");
        System.out.println(userDao.getById(id));
        // Поиск пользователей по логину
        String loginForSearch = "Alex";
        System.out.println("Вывод пользователей с логином " + loginForSearch + ":");
        List<IUser> usersByLogin = usersManager.getByLogin(loginForSearch);
        System.out.println(usersByLogin.size());
        for (IUser user : usersByLogin) {
            System.out.println(user);
        }
        // Поиск пользователей по имени
        String nameForSearch = "Николай";
        System.out.println("Вывод пользователей с именем " + nameForSearch + ":");
        List<IUser> usersByName = usersManager.getByName(nameForSearch);
        System.out.println(usersByName.size());
        for (IUser user : usersByName) {
            System.out.println(user);
        }
        // Поиск пользователей по роли
        UserRole role = UserRole.Admin;
        System.out.println("Вывод пользователей по роли " + role + ":");
        List<IUser> usersByRole = usersManager.getByRole(role);
        System.out.println(usersByRole.size());
        for (IUser user : usersByRole) {
            System.out.println(user);
        }
        // Добавление нового пользователя
        IUser creator = userDao.getById(123);
        IUser newUser = new User(767, "Jager", "19191", "Орлов Олег Александрович", UserRole.Admin, new Permissions());
        System.out.println("Добавляем нового пользователя!");
        userDao.create(creator, newUser);
        // Поиск пользователей по роли после добавления
        System.out.println("Вывод пользователей по роли " + role + " после добавления нового пользователя:");
        usersByRole = usersManager.getByRole(role);
        System.out.println(usersByRole.size());
        for (IUser user : usersByRole) {
            System.out.println(user);
        }
        // Удаление пользователя
        IUser deleter = creator;
        id = 357;
        System.out.println("Удаляем пользователя с id = " + id + ":");
        userDao.delete(deleter, id);
        // Поиск пользователей по роли после удаления
        System.out.println("Вывод пользователей по роли " + role + " после удаления пользователя:");
        usersByRole = usersManager.getByRole(role);
        System.out.println(usersByRole.size());
        for (IUser user : usersByRole) {
            System.out.println(user);
        }
    }

    public static void devicesCheck(DeviceDao deviceDao, DevicesManager devicesManager, UserDao userDao) {
        /* Проверяем работу DeviceDao и DevicesManager */
        // Вывод всех устройств
        System.out.println("Вывод всех устройств:");
        for (IDevice device: deviceDao.getAll()) {
            System.out.println(device);
        }
        // Вывод устройства с заданным id
        Integer id = 3;
        System.out.println("Вывод устройства с id = " + id + ":");
        System.out.println(deviceDao.getById(id));
        // Поиск устройств по имени
        String nameForSearch = "ВБИ-М08-45Р-1111";
        System.out.println("Вывод устройств с именем " + nameForSearch + ":");
        List<IDevice> devicesByName = devicesManager.getByName(nameForSearch);
        System.out.println(devicesByName.size());
        for (IDevice device : devicesByName) {
            System.out.println(device);
        }
        // Поиск устройств по типу
        String typeForSearch = "асинхронный двигатель";
        System.out.println("Вывод устройств типа " + typeForSearch + ":");
        List<IDevice> devicesByType = devicesManager.getByType(typeForSearch);
        System.out.println(devicesByType.size());
        for (IDevice device : devicesByType) {
            System.out.println(device);
        }
        // Поиск устройств по производителю
        String manufacturerForSearch = "ABB";
        System.out.println("Вывод устройств с производителем " + manufacturerForSearch + ":");
        List<IDevice> devicesByManufacturer = devicesManager.getByManufacturer(manufacturerForSearch);
        System.out.println(devicesByManufacturer.size());
        for (IDevice device : devicesByManufacturer) {
            System.out.println(device);
        }
        // Поиск устройств по категории
        String categoryForSearch = "МЕХАНИКА";
        System.out.println("Вывод устройств с категорией " + categoryForSearch + ":");
        List<IDevice> devicesByCategory = devicesManager.getByCategory(categoryForSearch);
        System.out.println(devicesByCategory.size());
        for (IDevice device : devicesByCategory) {
            System.out.println(device);
        }
        // Добавление нового устройства
        IUser creator = userDao.getById(123);
        IDevice newDevice = new SimpleDevice(13, "6304GTHYA NV", "роликовый подшипник", "МЕХАНИКА", "SEW");
        System.out.println("Добавляем новое устройство!");
        deviceDao.create(creator, newDevice); //???
        // Вывод всех устройств после добавления
        System.out.println("Вывод всех устройств после добавления нового устройства:");
        for (IDevice device: deviceDao.getAll()) {
            System.out.println(device);
        }
        // Удаление устройства
        IUser deleter = creator;
        id = 3;
        System.out.println("Удаляем устройство с id = " + id + ":");
        deviceDao.delete(deleter, id);
        // Вывод всех устройств после удаления
        System.out.println("Вывод всех устройств после удаления одного устройства:");
        for (IDevice device: deviceDao.getAll()) {
            System.out.println(device);
        }
    }

    public static void worksCheck(WorkDao workDao, WorksManager worksManager, DeviceDao deviceDao, UserDao userDao) {
        /* Проверяем работу workDao и worksManager */
        // Вывод всех работ
        System.out.println("Вывод всех работ:");
        for (IWork work: workDao.getALl()) {
            System.out.println(work);
        }
        // Вывод работы с заданным id
        Integer id = 11;
        System.out.println("Вывод работы с id = " + id + ":");
        System.out.println(workDao.getById(id));
        // Добавление устройств в работу
        System.out.println("Добавляем устройства к работе с id = " + id + ":");
        workDao.getById(id).addDevice(deviceDao.getById(2));
        workDao.getById(id).addDevice(deviceDao.getById(13));
        // Поиск работ поимени устройства
        String nameForSearch = "ВБИ-М08-45Р-1111";
        System.out.println("Вывод работ с именем устройства " + nameForSearch + ":");
        List<IWork> worksByDeviceName = worksManager.getByDeviceName(nameForSearch);
        System.out.println(worksByDeviceName.size());
        for (IWork work : worksByDeviceName) {
            System.out.println(work);
        }
        // Поиск работ id устройства
        Integer idForSearch = 2;
        System.out.println("Вывод работ с id устройства " + idForSearch + ":");
        List<IWork> worksByDeviceId = worksManager.getByDeviceId(idForSearch);
        System.out.println(worksByDeviceId.size());
        for (IWork work : worksByDeviceId) {
            System.out.println(work);
        }
        // Поиск работ по заданному времени устройства
        LocalTime startTime = LocalTime.of(13, 0, 0);
        LocalTime finishTime = LocalTime.of(14,55,0);
        System.out.println("Вывод работ по заданному периоду времени :");
        List<IWork> worksByTime = worksManager.getByTime(startTime, finishTime);
        System.out.println(worksByTime.size());
        for (IWork work : worksByTime) {
            System.out.println(work);
        }
        // Поиск работ по участку
        String place = "ЦЕХ ДСП";
        System.out.println("Вывод работ по участку " + place + ":");
        List<IWork> worksByPlace = worksManager.getByPlace(place);
        System.out.println(worksByPlace.size());
        for (IWork work : worksByPlace) {
            System.out.println(work);
        }
        // Поиск работ по локальной позиции
        String locationPosition = "2500MT13";
        System.out.println("Вывод работ по локальной позиции '" + locationPosition + "':");
        List<IWork> worksByLocationPosition = worksManager.getByLocationPosition(locationPosition);
        System.out.println(worksByLocationPosition.size());
        for (IWork work : worksByLocationPosition) {
            System.out.println(work);
        }
        // Добавление новой работы
        IUser creator = userDao.getById(123);
        IWork newWork = new Work(25, "ОТДЕЛЕНИЕ СУШКИ", "2250LS13", LocalTime.of(13, 33, 0), LocalTime.of(16,16,0));
        System.out.println("Добавляем новую работу!");
        workDao.create(creator, newWork);
        // Вывод всех работ после добавления новой
        System.out.println("Вывод всех работ после добавления новой:");
        for (IWork work: workDao.getALl()) {
            System.out.println(work);
        }
        // Удаление работы
        IUser deleter = creator;
        Integer idForDelete = 16;
        System.out.println("Удаляем работу с id = " + idForDelete + ":");
        workDao.delete(deleter, idForDelete);
        // Удаление устройства из работы
        System.out.println("Удаляем устройство из работы с id = " + id + ":");
        workDao.getById(id).deleteDevice(deviceDao.getById(2));
        // Вывод всех работ после удалений
        System.out.println("Вывод всех работ после удалений:");
        for (IWork work: workDao.getALl()) {
            System.out.println(work);
        }

    }
}