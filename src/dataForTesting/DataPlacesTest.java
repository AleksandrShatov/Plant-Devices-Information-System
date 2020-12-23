package dataForTesting;

import java.util.HashSet;
import java.util.Set;

/**
 * Класс, содержащий стартовый набор участков для тестирования
 */
public class DataPlacesTest {

    private static DataPlacesTest instance;

    private Set<String> places;

    private DataPlacesTest() {
        this.places = new HashSet<>();
        places.add("ЦЕХ ДСП");
        places.add("ЦЕХ ЛДСП");
        places.add("РУБИТЕЛЬНОЕ ОТДЕЛЕНИЕ");
        places.add("ОТДЕЛЕНИЕ СУШКИ");
        places.add("ТЕРМОМАСЛЯНАЯ КОТЕЛЬНАЯ");
    }

    public Set<String> getPlaces() {
        return places;
    }

    public static DataPlacesTest getInstance() {
        if(instance == null) {
            instance = new DataPlacesTest();
        } else {
            throw new IllegalArgumentException("Объект DataPlacesTest уже создан!");
        }
        return instance;
    }
}
