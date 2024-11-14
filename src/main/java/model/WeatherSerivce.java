package model;

import model.weather.Weather;

public class WeatherSerivce implements Service {
    private Connection connection;
    private JsonFormatter jsonFormatter;
    private static final String EMPTY_ERROR = "Вы не ввели город";
    private static final String CITY_ERROR = "Неверное название города";

    public WeatherSerivce() {
        connection = new Connection();
        jsonFormatter = new JsonFormatter();
    }

    @Override
    public String get(String city) {
        if (city.equals("")) {
            return EMPTY_ERROR;
        }

        try {
            String info = connection.getJSON(city);
            Weather weather = jsonFormatter.parse(info);
            String answer = weather.toString();

            return answer;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return CITY_ERROR;

        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
