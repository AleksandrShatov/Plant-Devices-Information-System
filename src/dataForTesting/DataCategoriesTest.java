package dataForTesting;

import java.util.HashSet;
import java.util.Set;

/**
 * Класс, содержащий стартовый набора категорий для тестирования
 */
public class DataCategoriesTest {

    private static DataCategoriesTest instance;

    private Set<String> categories;

    private DataCategoriesTest() {
        this.categories = new HashSet<>();
        categories.add("КИП");
        categories.add("МЕХАНИКА");
        categories.add("ЭЛЕКТРОНИКА");
        categories.add("ГИДРАВЛИКА");
        categories.add("ЭНЕРГЕТИКА");
        categories.add("ЛАБОРАТОРНОЕ ОБОРУДОВАНИЕ");
        categories.add("ПНЕВМАТИКА");
    }

    public Set<String> getCategories() {
        return categories;
    }

    public static DataCategoriesTest getInstance() {
        if(instance == null) {
            instance = new DataCategoriesTest();
        } else {
            throw new IllegalArgumentException("Объект DataCategoriesTest уже создан!");
        }
        return instance;
    }
}
