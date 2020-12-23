package dto;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class PreventiveMaintenance implements IMaintenance{
    private MaintenanceTimes plannedTime;
    private MaintenanceTimes actualTime;
    private List<IWork> works;
    private MaintenanceStatus status;

    public PreventiveMaintenance(MaintenanceTimes plannedTime, MaintenanceTimes actualTime, MaintenanceStatus status) {
        this.plannedTime = plannedTime;
        this.actualTime = actualTime;
        this.status =status;
        this.works = new ArrayList<>();
    }

    public MaintenanceTimes getPlannedTime() {
        return plannedTime;
    }

    public void setPlannedTime(MaintenanceTimes plannedTime) {
        this.plannedTime = plannedTime;
    }

    public MaintenanceTimes getActualTime() {
        return actualTime;
    }

    public void setActualTime(MaintenanceTimes actualTime) {
        this.actualTime = actualTime;
    }

    public List<IWork> getWorks() {
        return works;
    }

    public void setWorks(List<IWork> works) {
        this.works = works;
    }

    public MaintenanceStatus getStatus() {
        return status;
    }

    public void setStatus(MaintenanceStatus status) {
        this.status = status;
    }

    public Time getTotalTime() { //TODO
        long time = 0L;
        for (IWork work : works) {

        }
        return new Time(time);
    }

    public List<IDevice> getAllDevices() { //TODO
        List<IDevice> devices = new ArrayList<>();

        return devices;
    }

}
