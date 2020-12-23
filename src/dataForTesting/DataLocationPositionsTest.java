package dataForTesting;

import java.util.HashSet;
import java.util.Set;

/**
 * Класс, содержащий стартовый набор локальных позиций для тестирования
 */
public class    DataLocationPositionsTest {

    private static DataLocationPositionsTest instance;

    private Set<String> locationPositions;

    private DataLocationPositionsTest() {
        this.locationPositions = new HashSet<>();
        locationPositions.add("1500LS15");
        locationPositions.add("2200TS11");
        locationPositions.add("1150RP28");
        locationPositions.add("5500BR19");
        locationPositions.add("4400LI33");
        locationPositions.add("2700TS55");
        locationPositions.add("2500MT13");
        locationPositions.add("2250LS13");
        locationPositions.add("2700PT31");
    }

    public Set<String> getLocationPositions() {
        return locationPositions;
    }

    public static DataLocationPositionsTest getInstance() {
        if(instance == null) {
            instance = new DataLocationPositionsTest();
        } else {
            throw new IllegalArgumentException("Объект DataLocationPositionsTest уже создан!");
        }
        return instance;
    }
}
