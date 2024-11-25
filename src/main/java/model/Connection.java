package model;

import model.database.DatabaseConnection;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.Scanner;

public class Connection {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("api.properties")) {
            if (input == null) {
                System.out.println("Конфигурационный файл не найден");
            }
            properties.load(input);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getJSON(String city) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();

        URL url = new URL("http://api.weatherstack.com/current?access_key=" + properties.getProperty("key") + "&query=" + city);
        URLConnection connection = url.openConnection();
        Scanner scanner = new Scanner(connection.getInputStream());
        while (scanner.hasNext()) {
            stringBuilder.append(scanner.nextLine());
        }

        System.out.println("Ответ сервера: " + stringBuilder);

        return stringBuilder.toString();
    }
}
