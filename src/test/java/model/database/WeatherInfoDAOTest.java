//package model.database;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.io.InputStream;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Properties;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//public class WeatherInfoDAOTest {
//    private WeatherInfoDAO weatherInfoDAO;
//    private Connection connection;
//
//    @BeforeEach
//    public void setUp() throws Exception {
//        // Given: Чтение конфигурационного файла для подключения к тестовому контейнеру
//        final Properties properties = new Properties();
//
//        try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("db_test.properties")) {
//            if (input == null) {
//                System.out.println("Тестовый конфигурационный файл не найден");
//            }
//            properties.load(input);
//        }
//
//        String url = properties.getProperty("url");
//        String username = properties.getProperty("username");
//        String password = properties.getProperty("password");
//
//        // When: Подключение к тестовому БД
//        connection = DriverManager.getConnection(url, username, password);
//
//        // Then: Инициализация DAO
//        weatherInfoDAO = new WeatherInfoDAO();
//    }
//
//    @Test
//    public void testAddCity() throws SQLException {
//        //Given
//        String city = "Paris";
//
//        // When
//        weatherInfoDAO.addCity(city);
//        verify(mockPreparedStatement).executeUpdate();
//
//        // Then
//
//    }
//
//    @Test
//    public void testGetCityId() throws SQLException {
//        //Given
//
//        when(mockResultSet.next()).thenReturn(true);
//        when(mockResultSet.getInt("id")).thenReturn(1);
//        int cityId = weatherInfoDAO.getCityId("Paris");
//
//        assertEquals(1, cityId);
//    }
//}
