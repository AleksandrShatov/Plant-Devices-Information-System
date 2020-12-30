package app.menu.catalogs;

import app.dto.user.api.IUser;
import app.menu.api.AbstractMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TypesMenu extends AbstractMenu {

    private static TypesMenu instance;

    private TypesMenu() {
        super();
    }

    @Override
    public String getTitle(IUser currentUser) {
        return "Меню работы с типами";
    }

    public int show(IUser currentUser) {
        int choice = 0;
        do {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Меню работы с типами:");
            System.out.println("1. Вывод всех типов.");
            System.out.println("2. Поиск типа.");
            System.out.println("3. Добавление типа.");
            System.out.println("4. Удаление типа.");
            System.out.println("5. Выход в предыдущее меню.");
            try {
                String line = reader.readLine();
                choice = Integer.parseInt(line);
                BufferedReader typeReader = new BufferedReader(new InputStreamReader(System.in));
                String type = "";
                switch (choice) {
                    case 1:
                        System.out.println("СПИСОК ВСЕХ ТИПОВ:");
                        for(String tmpType : typesDao.getAll()) {
                            System.out.println(tmpType);
                        }
                        break;

                    case 2:
                        System.out.println("Введите название типа для поиска в каталоге:");
                        try {
                            type = typeReader.readLine();
                            System.out.println("Тип '" + type + "' " + (typesDao.isContainValue(type) ? "" : "не") + " содержится в каталоге.");
                        } catch (IOException e) {
                            System.out.println("Введено некорректное значение! Попробуйте заново.");
                        }
                        break;

                    case 3:
                        System.out.println("Введите название типа для добавления в каталог:");
                        try {
                            type = typeReader.readLine();
                            if(typesDao.isContainValue(type)) {
                                System.out.println("Тип '" + type + "' уже содержится в каталоге! Введите другой тип для добавления.");
                            } else {
                                if(typesDao.create(currentUser, type)) {
                                    System.out.println("Тип '" + type + "' успешно добавлен в каталог!");
                                } else {
                                    System.out.println("Произошла ошибка во время добавления типа! Попробуйте заново.");
                                }
                            }
                        } catch (IOException e) {
                            System.out.println("Введено некорректное значение! Попробуйте заново.");
                        }
                        break;

                    case 4:
                        System.out.println("Введите название типа для удаления из каталога:");
                        try {
                            type = typeReader.readLine();
                            if(!typesDao.isContainValue(type)) {
                                System.out.println("Тип '" + type + "' отсутствует в каталоге! Введите другой тип для удаления.");
                            } else {
                                if(typesDao.delete(currentUser, type)) {
                                    System.out.println("Тип '" + type + "' успешно удалён из каталога!");
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

    public static TypesMenu getInstance() {
        if(instance == null) {
            instance = new TypesMenu();
        } else {
            throw new IllegalArgumentException("Объект TypesMenu уже существует!");
        }
        return instance;
    }
}
