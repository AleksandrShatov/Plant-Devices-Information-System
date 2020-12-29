package menu.catalogs;

import dto.IUser;
import menu.AbstractMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CategoriesMenu extends AbstractMenu {

    private static CategoriesMenu instance;

    private CategoriesMenu() {

    }

    public int show(IUser currentUser) {
        int choice = 0;
        do {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Меню работы с категориями:");
            System.out.println("1. Вывод всех категорий.");
            System.out.println("2. Поиск категории.");
            System.out.println("3. Добавление категории.");
            System.out.println("4. Удаление категории.");
            System.out.println("5. Выход в предыдущее меню.");
            try {
                String line = reader.readLine();
                choice = Integer.parseInt(line);
                BufferedReader categoryReader = new BufferedReader(new InputStreamReader(System.in));
                String category = "";
                switch (choice) {
                    case 1:
                        System.out.println("СПИСОК ВСЕХ КАТЕГОРИЙ:");
                        for(String tmpCategory : categoriesDao.getAll()) {
                            System.out.println(tmpCategory);
                        }
                        break;

                    case 2:
                        System.out.println("Введите название категории для поиска в каталоге:");
                        try {
                            category = categoryReader.readLine();
                            System.out.println("Категория '" + category + "' " + (categoriesDao.isContainValue(category) ? "" : "не") + " содержится в каталоге.");
                        } catch (IOException e) {
                            System.out.println("Введено некорректное значение! Попробуйте заново.");
                        }
                        break;

                    case 3:
                        System.out.println("Введите название категории для добавления в каталог:");
                        try {
                            category = categoryReader.readLine();
                            if(categoriesDao.isContainValue(category)) {
                                System.out.println("Категория '" + category + "' уже содержится в каталоге! Введите другую категорию для добавления.");
                            } else {
                                if(categoriesDao.create(currentUser, category)) {
                                    System.out.println("Категория '" + category + "' успешно добавлена в каталог!");
                                } else {
                                    System.out.println("Произошла ошибка во время добавления категории! Попробуйте заново.");
                                }
                            }
                        } catch (IOException e) {
                            System.out.println("Введено некорректное значение! Попробуйте заново.");
                        }
                        break;

                    case 4:
                        System.out.println("Введите название категории для удаления из каталога:");
                        try {
                            category = categoryReader.readLine();
                            if(!categoriesDao.isContainValue(category)) {
                                System.out.println("Категория '" + category + "' отсутствует в каталоге! Введите ругую категорию для удаления.");
                            } else {
                                if(categoriesDao.delete(currentUser, category)) {
                                    System.out.println("Категория '" + category + "' успешно удалена из каталога!");
                                } else {
                                    System.out.println("Произошла ошибка во время удаления категории! Попробуйте заново.");
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

    public static CategoriesMenu getInstance() {
        if(instance == null) {
            instance = new CategoriesMenu();
        } else {
            throw new IllegalArgumentException("Объект CategoriesMenu уже существует!");
        }
        return instance;
    }

}
