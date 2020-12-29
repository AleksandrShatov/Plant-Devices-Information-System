package menu.catalogs;

import dto.IUser;
import menu.AbstractMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ManufacturersMenu extends AbstractMenu {

    private static ManufacturersMenu instance;

    private ManufacturersMenu() {

    }

    public int show(IUser currentUser) {
        int choice = 0;
        do {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Меню работы с производителями:");
            System.out.println("1. Вывод всех производителей.");
            System.out.println("2. Поиск производителя.");
            System.out.println("3. Добавление производителя.");
            System.out.println("4. Удаление производителя.");
            System.out.println("5. Выход в предыдущее меню.");
            try {
                String line = reader.readLine();
                choice = Integer.parseInt(line);
                BufferedReader manufacturerReader = new BufferedReader(new InputStreamReader(System.in));
                String manufacturer = "";
                switch (choice) {
                    case 1:
                        System.out.println("СПИСОК ВСЕХ ПРОИЗВОДИТЕЛЕЙ:");
                        for(String tmpManufacturer : manufacturesDao.getAll()) {
                            System.out.println(tmpManufacturer);
                        }
                        break;

                    case 2:
                        System.out.println("Введите название производителя для поиска в каталоге:");
                        try {
                            manufacturer = manufacturerReader.readLine();
                            System.out.println("Производитель '" + manufacturer + "' " + (manufacturesDao.isContainValue(manufacturer) ? "" : "не") + " содержится в каталоге.");
                        } catch (IOException e) {
                            System.out.println("Введено некорректное значение! Попробуйте заново.");
                        }
                        break;

                    case 3:
                        System.out.println("Введите название производителя для добавления в каталог:");
                        try {
                            manufacturer = manufacturerReader.readLine();
                            if(manufacturesDao.isContainValue(manufacturer)) {
                                System.out.println("Производитель '" + manufacturer + "' уже содержится в каталоге! Введите другого производителя для добавления.");
                            } else {
                                if(manufacturesDao.create(currentUser, manufacturer)) {
                                    System.out.println("Производитель '" + manufacturer + "' успешно добавлен в каталог!");
                                } else {
                                    System.out.println("Произошла ошибка во время добавления типа! Попробуйте заново.");
                                }
                            }
                        } catch (IOException e) {
                            System.out.println("Введено некорректное значение! Попробуйте заново.");
                        }
                        break;

                    case 4:
                        System.out.println("Введите название производителя для удаления из каталога:");
                        try {
                            manufacturer = manufacturerReader.readLine();
                            if(!manufacturesDao.isContainValue(manufacturer)) {
                                System.out.println("Производитель '" + manufacturer + "' отсутствует в каталоге! Введите другого производителя для удаления.");
                            } else {
                                if(manufacturesDao.delete(currentUser, manufacturer)) {
                                    System.out.println("Производитель '" + manufacturer + "' успешно удалён из каталога!");
                                } else {
                                    System.out.println("Произошла ошибка во время удаления типа! Попробуйте заново.");
                                }
                            }
                        } catch (IOException e) {
                            System.out.println("Введено некорректное значение! Попробуйте заново.");
                        }
                        break;

                    case 5:
                        return 0;
                }


            } catch (IOException e) {
                System.out.println("Введено неверное значение! Попробуйте заново.");
            }

        } while (choice < 6 && choice >= 0);

        return 13;
    }

    public static ManufacturersMenu getInstance() {
        if(instance == null) {
            instance = new ManufacturersMenu();
        } else {
            throw new IllegalArgumentException("Объект ManufacturersMenu уже существует!");
        }
        return instance;
    }
}
