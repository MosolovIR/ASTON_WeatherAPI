package model.weather;

public class Location {
    private String lat;
    private String lon;
    private String name;

    String getLat() {
        return lat;
    }

    private void setLat(String lat) {
        this.lat = lat;
    }

    String getLon() {
        return lon;
    }

    private void setLon(String lon) {
        this.lon = lon;
    }

    String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}