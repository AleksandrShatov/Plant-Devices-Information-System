package dto;

public class PlacePosition {
    private String place;
    private String locationPosition;

    public PlacePosition(String place, String locationPosition) {
        this.place = place;
        this.locationPosition = locationPosition;
    }

    public PlacePosition(String place) {
        this.place = place;
        this.locationPosition = "";
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getLocationPosition() {
        return locationPosition;
    }

    public void setLocationPosition(String locationPosition) {
        this.locationPosition = locationPosition;
    }

    @Override
    public String toString() {
        return "{" +
                "place='" + place + '\'' +
                ", locationPosition='" + locationPosition + '\'' +
                '}';
    }
}
