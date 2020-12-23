package dataForTesting;

import java.util.HashSet;
import java.util.Set;

/**
 * Класс, содержащий стартовый набора типов для тестирования
 */
public class DataTypesTest {

    private static DataTypesTest instance;

    private Set<String> types;

    private DataTypesTest() {
        this.types = new HashSet<>();
        types.add("индуктивный датчик");
        types.add("электромагнитный расходомер");
        types.add("шариковый подшипник");
        types.add("асинхронный двигатель");
        types.add("оптический датчик");
        types.add("газовая горелка");
        types.add("частотный преобразователь");
    }

    public Set<String> getTypes() {
        return types;
    }

    public static DataTypesTest getInstance() {
        if(instance == null) {
            instance = new DataTypesTest();
        } else {
            throw new IllegalArgumentException("Объект DataTypesTest уже создан!");
        }
        return instance;
    }
}
