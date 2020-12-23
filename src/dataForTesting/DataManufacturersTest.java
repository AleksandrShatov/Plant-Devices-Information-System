package dataForTesting;

import java.util.HashSet;
import java.util.Set;

/**
 * Класс, содержащий стартовый набор производителй для тестирования
 */
public class DataManufacturersTest {

    private static DataManufacturersTest instance;

    private Set<String> manufacturers;

    private DataManufacturersTest() {
        this.manufacturers = new HashSet<>();
        manufacturers.add("SIEMENS");
        manufacturers.add("ABB");
        manufacturers.add("MITSUBISHI");
        manufacturers.add("OMRON");
        manufacturers.add("SCHNEIDER ELECTRIC");
        manufacturers.add("СЕНСОР");
        manufacturers.add("ТЕКО");
    }

    public Set<String> getManufacturers() {
        return manufacturers;
    }

    public static DataManufacturersTest getInstance() {
        if(instance == null) {
            instance = new DataManufacturersTest();
        } else {
            throw new IllegalArgumentException("Объект DataManufacturersTest уже создан!");
        }
        return instance;
    }
}
