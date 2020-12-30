package app.dao;

import app.dao.api.IWorkDao;
import app.dto.user.api.IUser;
import app.dto.maintenance.api.IWork;
import app.dto.maintenance.Work;

import java.time.LocalTime;
import java.util.*;

public class WorkDao implements IWorkDao {

    private static WorkDao instance;

    private Map<Integer, IWork> works;

    public WorkDao() {
        readWorks();
    }

    private boolean readWorks() { //TODO чтение из БД
        if(this.works == null) {
            List<IWork> worksList = new ArrayList<>();
            worksList.add(new Work(11, "ЦЕХ ДСП", "2700TS55", LocalTime.of(10, 30, 0), LocalTime.of(10,50,0)));
            worksList.add(new Work(12, "ЦЕХ ДСП", "1500LS15", LocalTime.of(11, 10, 0), LocalTime.of(12,30,0)));
            worksList.add(new Work(13, "ЦЕХ ДСП", "2200TS11", LocalTime.of(13, 30, 0), LocalTime.of(13,55,0)));
            worksList.add(new Work(14, "ЦЕХ ЛДСП", "4400LI33", LocalTime.of(14, 5, 0), LocalTime.of(14,45,0)));
            worksList.add(new Work(15, "ЦЕХ ЛДСП", "2700PT31", LocalTime.of(14, 55, 0), LocalTime.of(15,35,0)));
            worksList.add(new Work(16, "РУБИТЕЛЬНОЕ ОТДЕЛЕНИЕ", "2500MT13", LocalTime.of(15, 50, 0), LocalTime.of(17,40,0)));
            this.works = new HashMap<>();
            for (IWork work : worksList) {
                this.works.put(work.getId(), work);
            }
            return true;
        }
        return false;
    }

    @Override
    public IWork getById(Integer workId) {
        for (IWork work : getALl())  {
            if(workId.intValue() == work.getId()) {
                return work;
            }
        }
        return null; // TODO
    }

    @Override
    public List<IWork> getALl() {
        Set<Map.Entry<Integer, IWork>> setOfWorks = this.works.entrySet();
        List<IWork> allWorks = new ArrayList<>();
        for(Map.Entry<Integer, IWork> mapElement : setOfWorks) {
            IWork work = mapElement.getValue();
            allWorks.add(work);
        }
        return allWorks;
    }

    @Override
    public boolean create(IUser whoCreate, IWork newWork) {
        if(whoCreate.checkPermission("CAN_CREATE_WORK")) {
            works.put(works.size(), newWork);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(IUser whoUpdate, IWork workForUpdate) {
        if(whoUpdate.checkPermission("CAN_UPDATE_WORK")) {

            return true;
        }
        return false;
    }

    @Override
    public boolean delete(IUser whoDelete, int workId) {
        if(whoDelete.checkPermission("CAN_DELETE_WORK")) {
            IWork work = getById(workId);
            if(work != null) {
                return works.remove(work.getId(), work);
            }
        }
        return false;
    }

    public static WorkDao getInstance() {
        if(instance == null) {
            instance = new WorkDao();
        } else {
            throw new IllegalArgumentException("Объект WorkDao уже создан!");
        }
        return instance;
    }
}
