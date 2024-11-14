package model;

import com.google.gson.Gson;
import model.weather.Weather;

public class JsonFormatter {
    public Weather parse(String json) {
        Gson gson = new Gson();
        Weather weather = gson.fromJson(json, Weather.class);
        return weather;
    }
}
