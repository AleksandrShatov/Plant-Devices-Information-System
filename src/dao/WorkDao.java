package dao;

import dataForTesting.DataWorksTest;
import dto.IUser;
import dto.IWork;

import java.util.*;

public class WorkDao implements IWorkDao {

    private static WorkDao instance;

    private Map<Integer, IWork> works;

    public WorkDao() {
        readWorks();
    }

    private boolean readWorks() { //TODO чтение из БД
        if(this.works == null) {
            List<IWork> worksFromDb = DataWorksTest.getInstance().getWorks();
            this.works = new HashMap<>();
            for (IWork work : worksFromDb) {
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
