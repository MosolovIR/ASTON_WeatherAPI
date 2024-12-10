package com.aston.WeatherAPI.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WeatherDTO {
    private Location location;
    private Current current;

    @Setter
    @Getter
    public static class Location {
        private String name;

    }

    @Setter
    @Getter
    public static class Current {
        private int temperature;
        private int pressure;
        private int humidity;

    }
}