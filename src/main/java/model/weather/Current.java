package model.weather;

public class Current {
    private int temperature;
    private String observationTime;
    private int pressure;
    private int humidity;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getObservationTime() {
        return observationTime;
    }

    public void setObservationTime(String observationTime) {
        this.observationTime = observationTime;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}
