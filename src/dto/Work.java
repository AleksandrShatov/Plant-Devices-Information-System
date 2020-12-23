package dto;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Work implements IWork {
    private Integer id;
    private PlacePosition placePosition;
    private LocalTime startTime;
    private LocalTime finishTime;
    private List<IDevice> devicesForWork;
    private String description;

    public Work(Integer id, PlacePosition placePosition, LocalTime startTime, LocalTime finishTime) {
        this.id = id;
        this.placePosition = placePosition;
        this.startTime = startTime;
        this.finishTime= finishTime;
        this.description = "";
        this.devicesForWork = new ArrayList<>();
    }

    public Work(Integer id, String place, String locationPosition, LocalTime startTime, LocalTime finishTime) {
        this.id = id;
        this.placePosition = new PlacePosition(place, locationPosition);
        this.startTime = startTime;
        this.finishTime= finishTime;
        this.description = "";
        this.devicesForWork = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PlacePosition getPlacePosition() {
        return placePosition;
    }

    public String getPlace() {
        return this.placePosition.getPlace();
    }

    public String getLocationPosition() {
        return this.placePosition.getLocationPosition();
    }

    public void setPlacePosition(PlacePosition placePosition) {
        this.placePosition = placePosition;
    }

    public void setPlace(String place) {
        this.placePosition.setPlace(place);
    }

    public void setLocationPosition(String locationPosition) {
        this.placePosition.setLocationPosition(locationPosition);
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(int hours, int minutes, int seconds) {
        this.startTime = LocalTime.of(hours, minutes, seconds);
    }

    public LocalTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int hours, int minutes, int seconds) {
        this.finishTime = LocalTime.of(hours, minutes, seconds);
    }

    public List<IDevice> getDevices() {
        return devicesForWork;
    }

    public void setDevicesForWork(List<IDevice> devicesForWork) {
        this.devicesForWork = devicesForWork;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean addDevice(IDevice device) {
       return devicesForWork.add(device);
    }

    public boolean deleteDevice(IDevice device) {
        boolean result = false;
        if(devicesForWork.contains(device)) {
            result = devicesForWork.remove(device);
        } else {
            System.out.println("Данного устройства в текущей работе не обнаружено!");
        }
        return result;
    }

    public LocalTime getTotalTime() {
        int hours = finishTime.getHour() - startTime.getHour();
        int minutes = finishTime.getMinute() - startTime.getMinute();
        int seconds = finishTime.getSecond() - startTime.getSecond();

        return LocalTime.of(hours, minutes, seconds);
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", placePosition=" + placePosition.toString() +
                ", startTime=" + "{" + startTime.getHour() + ":" +
                startTime.getMinute() + ":" + startTime.getSecond() + "}" +
                ", finishTime=" + "{" + finishTime.getHour() + ":" +
                finishTime.getMinute() + ":" + finishTime.getSecond() + "}" +
                ", devicesForWork=" + devicesForWork.toString() +
                ", description='" + description + '\'' +
                '}';
    }
}
