package model.database;

import model.weather.Weather;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WeatherInfoDAO {

    public void addCity(String city) throws SQLException {
        String query = "INSERT INTO weather_app.cities (name) VALUES (?) ON CONFLICT (name) DO NOTHING";

        try (Connection connection = DatabaseConnection.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, city);
            preparedStatement.executeUpdate();
        }
    }

    public int getCityId (String city) throws SQLException {
        String query = "SELECT id FROM weather_app.cities WHERE name = ?";

        try (Connection connection = DatabaseConnection.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, city);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("id");
            } else {
                return -1;
            }
        }
    }

    public void deleteCity(int cityId) throws SQLException {
        String query = "DELETE FROM weather_app.cities WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, cityId);
            preparedStatement.executeUpdate();
        }
    }

    public List<String> getAllCities () throws SQLException {
        List<String> cities = new ArrayList<>();
        String query = "SELECT * FROM weather_app.cities";

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                cities.add(resultSet.getString("name"));
            }
        }
        return cities;
    }

    public void logRequest (int cityId) throws SQLException {
        String query = "INSERT INTO weather_app.request_history (city_id) VALUES (?)";

        try (Connection connection = DatabaseConnection.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, cityId);
            preparedStatement.executeUpdate();
        }
    }

    public List<String> getRequestHistory () throws SQLException {
        List<String> requestHistory = new ArrayList<>();
        String query = "SELECT * FROM weather_app.request_history";

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String record = "ID: " + resultSet.getInt("id") +
                                ", cityId: " + resultSet.getInt("city_id") +
                                ", Time: " + resultSet.getTimestamp("request_time");

                requestHistory.add(record);
            }
        }
        return requestHistory;
    }

    public void saveWeatherData(int cityId, Weather weather) throws SQLException {
        String query = "INSERT INTO weather_app.weather_data (city_id, temperature, pressure) " +
                "VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, cityId);
            preparedStatement.setInt(2,weather.getCurrent().getTemperature());
            preparedStatement.setInt(3,weather.getCurrent().getPressure());
            preparedStatement.executeUpdate();
        }
    }

    public void addCityWithWeatherDataAndLog(String city, Weather weather) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        try {
            connection.setAutoCommit(false);
            addCity(city);

            int cityId = getCityId(city);

            saveWeatherData(cityId, weather);
            logRequest(cityId);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }
}


