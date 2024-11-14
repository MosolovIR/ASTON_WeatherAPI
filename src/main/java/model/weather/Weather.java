package model.weather;

public class Weather {
    private Current current;
    private Location location;

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Город:'" + location.getName() + '\'' + '\n' +
               "Температура: " + current.getTemperature() + " (по Цельсию) " + '\n' +
               "Атмосферное давление: " + current.getPressure() + " мм. " + '\n' +
               "Влажность воздуха: " + current.getHumidity() + " % " + '\n' +
               "Широта/Долгота: " + location.getLat() + "/" + location.getLon();
    }
}
