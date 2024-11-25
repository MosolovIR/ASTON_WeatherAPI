package model.database;

import java.sql.Connection;

public class DatabaseConnectionTest {

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Успешное подключение к БД!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
