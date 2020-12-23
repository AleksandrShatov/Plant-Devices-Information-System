package dataForTesting;

import dto.IWork;
import dto.Work;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс, содержащий стартовый набор работ для тестирования
 */
public class DataWorksTest {

    private static DataWorksTest instance;

    private List<IWork> works;

    private DataWorksTest() {
        this.works = new ArrayList<>();
        works.add(new Work(11, "ЦЕХ ДСП", "2700TS55", LocalTime.of(10, 30, 0), LocalTime.of(10,50,0)));
        works.add(new Work(12, "ЦЕХ ДСП", "1500LS15", LocalTime.of(11, 10, 0), LocalTime.of(12,30,0)));
        works.add(new Work(13, "ЦЕХ ДСП", "2200TS11", LocalTime.of(13, 30, 0), LocalTime.of(13,55,0)));
        works.add(new Work(14, "ЦЕХ ЛДСП", "4400LI33", LocalTime.of(14, 5, 0), LocalTime.of(14,45,0)));
        works.add(new Work(15, "ЦЕХ ЛДСП", "2700PT31", LocalTime.of(14, 55, 0), LocalTime.of(15,35,0)));
        works.add(new Work(16, "РУБИТЕЛЬНОЕ ОТДЕЛЕНИЕ", "2500MT13", LocalTime.of(15, 50, 0), LocalTime.of(17,40,0)));

    }

    public List<IWork> getWorks() {
        return works;
    }

    public static DataWorksTest getInstance() {
        if(instance == null) {
            instance = new DataWorksTest();
        } else {
            throw new IllegalArgumentException("Объект DataWorksTest уже создан!");
        }
        return instance;
    }

}
