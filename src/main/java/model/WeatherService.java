package model;

import model.database.WeatherInfoDAO;
import model.weather.Weather;

public class WeatherService implements Service {
    private static final String EMPTY_ERROR = "Вы не ввели город";
    private static final String CITY_ERROR = "Неверное название города";
    private Connection connection;
    private JsonFormatter jsonFormatter;
    private WeatherInfoDAO weatherInfoDAO;

    public WeatherService() {
        connection = new Connection();
        jsonFormatter = new JsonFormatter();
        weatherInfoDAO = new WeatherInfoDAO();
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
            weatherInfoDAO.addCityWithWeatherDataAndLog(city, weather);

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
