package app.dto.maintenance;

import java.time.LocalDate;
import java.time.LocalTime;

public class MaintenanceTimes {
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime finishTime;

    public MaintenanceTimes(LocalDate date, LocalTime startTime, LocalTime finishTime) {
        this.date = date;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalTime finishTime) {
        this.finishTime = finishTime;
    }
}
